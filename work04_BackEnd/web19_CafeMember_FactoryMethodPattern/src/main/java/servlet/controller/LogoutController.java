package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		//세션을 죽이는 로직...invalidate()
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") != null) { //현재 로그인된 상태
			session.invalidate();
			path = "logout.jsp";
		}
		
		return new ModelAndView(path);
	}

}
