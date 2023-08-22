package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id,password,name,address);
		
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			//로그인과 수정로직은 반드시 session에 바인딩~~!!
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {//로그인된 상태에서만 수정된 정보를 다시 저장...
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
			
		}catch(Exception e) {
			
		}
		
		return new ModelAndView(path);
	}

}
