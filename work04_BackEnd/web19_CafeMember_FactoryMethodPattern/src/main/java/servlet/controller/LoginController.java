package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		  String id = request.getParameter("id");
	      String password = request.getParameter("password");
	      
	      String path = "index.jsp";
	      
	      try {
	    	  MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
	    	  HttpSession session = request.getSession();
	    	  
	    	  if(rvo != null) {
	    		  session.setAttribute("vo", rvo);
	    		  System.out.println("JSESSION ID :: LoginServlet... " + session.getId());
	    		  path = "login_result.jsp";
	    	  }
	    		  
	      }catch(Exception e) {
	    	  path = "login.jsp";
	      }
	      
	      return new ModelAndView(path);
	}

}
