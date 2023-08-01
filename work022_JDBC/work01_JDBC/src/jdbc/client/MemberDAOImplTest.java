package jdbc.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;
import jdbc.exception.RecordNotFoundException;

public class MemberDAOImplTest {

	public static void main(String[] args) throws SQLException{
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		System.out.println("===================== [insertMember] ====================");
		
		try {
			dao.insertMember(new Member(1,"박혜수","a","a")); 	
			dao.insertMember(new Member(2,"윤아","b","b")); 
			dao.insertMember(new Member(3,"장동건","c","c")); 
			dao.insertMember(new Member(4,"정형돈","d","d")); 
		}catch(DuplicateIDException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [deleteMember] ====================");
		try {
			dao.deleteMember(1);
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [updateMember] ====================");
		try {
			dao.updateMember(new Member(3,"조원형","mesh153@naver.com","01036493276"));
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [getMember(id) - 1] ====================");
		try {
			System.out.println(dao.getMember(2));
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [getMember() - 2] ====================");
		
		for(Member m : dao.getMember()) {
			System.out.println(m);
		}
		
		System.out.println("===================== [getMember(String) - 3] ====================");
		for(Member m : dao.getMember("조원형")) {
			System.out.println(m);
		}
		
		System.out.println("==================== [insertMember... Duplicated Exception...]");
		try {
			dao.insertMember(new Member(2,"윤아","b","b")); 
		}catch(DuplicateIDException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [deleteMember... Record Not Found Exception...] ====================");
		try {
			dao.deleteMember(30);
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [updateMember... Record Not Found Exception...] ====================");
		try {
			dao.updateMember(new Member(100,"김모씨","ddd","aaa"));
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================== [getMember(id)... Record Not Found Exception...] ====================");
		try {
			System.out.println(dao.getMember(30));
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===========================================================");
		afterEach();
	}
	
	private static void afterEach() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		PreparedStatement ps = null;
		
		String q1 = "DROP SEQUENCE seq_id";
		String q2 = "truncate table member";
		
		ps = conn.prepareStatement(q1);
		ps.executeUpdate();
		
		ps = conn.prepareStatement(q2);
		ps.executeUpdate();
		
		System.out.println("afterEach Success...");
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success....");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		}
	}
}
