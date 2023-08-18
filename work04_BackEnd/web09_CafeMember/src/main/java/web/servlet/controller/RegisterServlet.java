package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    
    	/*
    	 * 1. 폼값 받기
    	 * 2. VO생성...PVO
    	 * 3. DAO리턴받고 비지니스로직 호출
    	 * 4. 네비게이션 register_result.jsp...
    	 * 
    	 * -> 바인딩 필요없다!!!
    	 */
    	
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("password");
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	
    	MemberVO pvo = new MemberVO(id,pwd,name,address);      
    	String path = "index.html";
    	
    	try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			//path = "register_result.jsp";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//request.getRequestDispatcher(path).forward(request, response);
    	response.sendRedirect("AllMember");
    }

}
