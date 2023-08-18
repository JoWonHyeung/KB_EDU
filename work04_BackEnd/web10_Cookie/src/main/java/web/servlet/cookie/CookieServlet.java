package web.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         
         //1. 쿠키 생성
         Cookie c1 = new Cookie("id","KBLife");
         Cookie c2 = new Cookie("today","2023-08-18");
         
         //쿠키안에 저장된 정보를 유지하는 기간을 지정
         c1.setMaxAge(24*60*60); // 하루동안 정보 보관
         c2.setMaxAge(2*24*60*60); // 이틀동안 정보 보관
         
         //2. 생성된 쿠키를 클라이언트로 보냄...브라우저에 저장
         response.addCookie(c1);
         response.addCookie(c2);
         
         //3. 페이지 이동...
         response.sendRedirect("getCookie.jsp");
         
    }



}
