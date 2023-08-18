package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
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

       //로직은 여기서 작성... 어떤 요청이 들어왔는지를...구분
       //register, login, find, showAll....
       String command = request.getParameter("command");
       String path = "index.html";
       
       if(command.equals("register")) { //회원가입 로직...
    	   path = register(request, response);
       }else if(command.equals("find")) {
    	   path = find(request, response);
       }else if(command.equals("login")) {
    	   path = login(request, response);
       }else if(command.equals("showAll")) {
    	   path = showAll(request, response);
       }
       
       request.getRequestDispatcher(path).forward(request, response);
   }//doProcess
	
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
    	String pwd = request.getParameter("password");
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	
    	MemberVO pvo = new MemberVO(id,pwd,name,address);      
    	String path = "index.html";
    	
    	try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
    	} catch (SQLException e) {

    	}
    	
    	return path;
	}//register

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String path = "find_fail.jsp";
        
        try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
		
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
        } catch (SQLException e) {
        	
		}
        
        return path;
	}//find
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	      String password = request.getParameter("password");
	      
	      String path = "index.html";
	      
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
	      
	      return path;
	}//login
	
	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return path;
	}//showAll
	
}
