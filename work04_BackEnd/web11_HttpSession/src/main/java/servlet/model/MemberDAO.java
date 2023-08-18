package servlet.model;
//O,O,O + O,O + ,,,,

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO {
	//공통적인 로직...
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//비지니스 로직...
	void registerMember(MemberVO vo) throws SQLException;
	ArrayList<MemberVO> showAllMember() throws SQLException;
	MemberVO findByIdMember(String id)throws SQLException;	
	
}






















