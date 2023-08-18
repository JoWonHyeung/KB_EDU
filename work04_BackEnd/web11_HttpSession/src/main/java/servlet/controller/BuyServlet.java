package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyServlet() {
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
	
	    //로직은 여기서 작성....이건 새로운 세션이 아니라 이전 세션일 것이다... 확인어캐함??...
	    //Jsession 찍어봐라!!
	    HttpSession session = request.getSession();
	    
	    if(session.getAttribute("vo") != null) { //로그인된 상태라면
	    	System.out.println("JSESSIONID.. BuryServlet :: " + session.getId());
	    	session.setAttribute("book", "오펜하이머");
	    	request.getRequestDispatcher("buy_result.jsp").forward(request, response);
	    }else { //로그인 안된 상태라면... 다시 로그인하러 보내야함...
	    	response.sendRedirect("login.html");
	    }
	    
	}

}
