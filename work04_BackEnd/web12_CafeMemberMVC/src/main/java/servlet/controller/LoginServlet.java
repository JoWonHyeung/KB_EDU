package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
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

      
      //로직은 여기서 작성...
      /*
        1. 폼값 받아서
        2. DAO 리턴 받고 비즈니스 로직 호출
        3. 반환값 받아서 .... null이 아니면 세션에 바인딩... 결과페이지(login_result.jsp)로 네비게이션
        4. null이 아니면 다시 로그인 페이지(login.jsp)로 이동
       */
      
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
      
      request.getRequestDispatcher(path).forward(request, response);
  }

}
