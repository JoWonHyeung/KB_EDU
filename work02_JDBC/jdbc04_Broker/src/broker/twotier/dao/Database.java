package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{

	public Database(String serverIp) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공....");
	}
	
	//공통로직
	public Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		
		return conn;
	}	
	
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}

	
	//ssn 여부 확인
	private boolean isExist(String ssn, Connection conn) throws SQLException{
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) { //id가 없다면...추가진행
				String query = 
						"INSERT INTO customer (ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+" 명 회원 등록~~!!");
			}else {
				//예외 발생...throw new DuplicateIDException()
				throw new DuplicateSSNException();
			}			
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) {
				String query = "DELETE customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate() + "명 삭제 완료");
			}else {
				throw new RecordNotFoundException();
			}
		}finally {
			closeAll(ps,conn);
		}
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnect();
            String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, cust.getName());
            ps.setString(2, cust.getAddress());
            ps.setString(3, cust.getSsn());

            int row = ps.executeUpdate();
            if(row==1)System.out.println(row+" 명 UPDATE OK...updateCustomer()...");
            else throw new RecordNotFoundException("수정할 대상의 고객이 없습니다");
        }finally {
            closeAll(ps, conn);
        }
	}

	//특정한 고객이 보유하고 있는 주식정보를 받아오는 기능
	//shares 테이블로부터 select해오겠다...
	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<SharesRec> list = new ArrayList<SharesRec>();
        try {
            conn = getConnect();
            String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn=?";
            
            ps = conn.prepareStatement(query);
            
            ps.setString(1, ssn);
            rs = ps.executeQuery();
            
            while(rs.next()) 
            	list.add(new SharesRec(ssn,
            			rs.getString("symbol"), 
            			rs.getInt("quantity")));

        }finally {
            closeAll(rs, ps, conn);
        }
		
		return list;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CustomerRec cust = null;
        
        try {
        	conn = getConnect();
        	String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
        	ps = conn.prepareStatement(query);
        	ps.setString(1, ssn);
        	
        	rs = ps.executeQuery();
        	if(rs.next()) {
        		cust = new CustomerRec(ssn, rs.getString("cust_name"),rs.getString("address"));
        		cust.setPortfolio(getPortfolio(ssn));
        	}
        	
        }finally {
        	closeAll(rs, ps, conn);
        }
        
		return cust;
	}

	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
        try {
            conn = getConnect();
            String query  ="SELECT ssn, cust_name, address FROM customer";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new CustomerRec(rs.getString("ssn"), 
                                         rs.getString("cust_name"), 
                                         rs.getString("address"),
                                         getPortfolio(rs.getString("ssn"))));
            }
        }finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }

	public ArrayList<StockRec> getAllStocks() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<StockRec> list = new ArrayList<StockRec>();
        try{
            conn = getConnect();
            String query = "SELECT symbol, price FROM stock";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new StockRec(rs.getString(1), 
                                       rs.getFloat(2)));
            }
        }finally{
            closeAll(rs, ps, conn);
        }
        return list;
    }

	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn=  getConnect();

	        String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, ssn);
	        ps.setString(2, symbol);
	
	        rs = ps.executeQuery();
	        if(rs.next()) {
	            int q=rs.getInt(1); //q는 현재 가지고 있는 주식의 수량
	            int newQuantity = q+quantity; //  q(50) + quantity(100)
	
	            //UPDATE
	            String query1 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
	            ps = conn.prepareStatement(query1);
	            ps.setInt(1, newQuantity);
	            ps.setString(2, ssn);
	            ps.setString(3, symbol);
	
	            System.out.println(ps.executeUpdate()+" row buyShares()....UPDATE OK");
	        }else { //주식이 없는 경우..
	            //INSERT
	            String query2 ="INSERT INTO shares (ssn, symbol, quantity) VALUES(?,?,?)";
	            ps = conn.prepareStatement(query2);
	            ps.setString(1, ssn);
	            ps.setString(2, symbol);
	            ps.setInt(3, quantity);
	
	            System.out.println(ps.executeUpdate()+" row buyShares()....INSERT OK");
	        }
	    } finally {
	        closeAll(rs, ps, conn);
	    }
    
	}

	
	public void sellShares(String ssn, String symbol, int quantity)
	            throws SQLException, InvalidTransactionException, RecordNotFoundException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            conn=  getConnect();
	
	        String query ="SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, ssn);
	        ps.setString(2, symbol);
	
	        rs = ps.executeQuery();
	
	        if(rs.next()){//일단 커서를 한단계 아래로 내려서 엘러먼트를 가리키게 하고 수량을 받아올 준비를 한다.
	
	            int q = rs.getInt(1); // 현재 가지고 있는 수량...100
	            int newQuantity = q-quantity; //팔고 남은 수량
	
	            if(q==quantity) { //delete
	                String query1 = "DELETE FROM shares WHERE ssn=? AND symbol=?";
	                ps = conn.prepareStatement(query1);
	                ps.setString(1, ssn);
	                ps.setString(2, symbol);
	
	                System.out.println(ps.executeUpdate()+" row SHARES DELETE....sellShares()1...");
	            }else if(q>quantity) { //update
	                String query2 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
	                ps = conn.prepareStatement(query2);
	
	                ps.setInt(1, newQuantity);
	                ps.setString(2, ssn);
	                ps.setString(3, symbol);
	
	                System.out.println(ps.executeUpdate()+" row SHARES UPDATE....sellShares()2...");
	            }else {  //펑
	                throw new InvalidTransactionException();
	            }
	        }else { //주식이 없다면..
	            throw new RecordNotFoundException();
	        }
	        }finally {
	            closeAll(rs, ps, conn);
	        }
	}


}
