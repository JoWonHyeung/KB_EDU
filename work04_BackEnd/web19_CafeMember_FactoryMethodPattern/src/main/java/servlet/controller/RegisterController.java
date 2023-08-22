package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
    	String pwd = request.getParameter("password");
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	
    	MemberVO pvo = new MemberVO(id,pwd,name,address);      
    	String path = "index.jsp";
    	
    	try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "front.do?command=showAll";
    	} catch (SQLException e) {

    	}
    	
    	return new ModelAndView(path, true);
	}

}
