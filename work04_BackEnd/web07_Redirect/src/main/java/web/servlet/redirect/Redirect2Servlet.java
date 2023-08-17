package web.servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect2") //forward하면 서블릿주소뜬다....
public class Redirect2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Redirect2Servlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받는다..(하나의 값만 받으세요)
		 * 2. 만약에 어느 값도 선택되지 않았다면 ... 에러페이지로 연결
		 * 	  하나의 값이 선택되었다면 redirect2.jsp로 바로 이동
		 * 
		 * 3. redirect2.sjp에서는 <% %> <%= %> wkf tkdydgotj 
		 *    당신이 선택한 도시는 ooo입니다 라고 출력
		 */
		
		String city = request.getParameter("city");
		
		
		if(city == null)
			response.sendRedirect("error/error2.html"); //forward 불가능!!!! 정적문서는 웹서버를 한 번 거쳐야한다...
		else
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		
	}


}
