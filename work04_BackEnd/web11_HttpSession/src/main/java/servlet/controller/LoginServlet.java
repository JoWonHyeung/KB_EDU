package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        /*
         * 1. 폼값 받아서...
         * 2. DAO 리턴 받고.. 비즈니스 로직 호출...
         * 3. 반환된 바인딩
         * 4. 결과 페이지로 네비게이션
         */
        
        //세션은 클라이언트가 서버에 요청시에 서버에 만들어진다...
        //만들어진 세션을 받아서 사용한다.
        
        HttpSession session = request.getSession();
        
        System.out.println("JSESSIONID :: " + session.getId());
	
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        MemberVO vo = new MemberVO(id, password, "김국진","mesh153@naver.com");
        
        //비즈니스 로직 호출... 결과값 반환...
        
        //바인딩 
        //로그인...회원수정 바인딩은 반드시 session attribute이다.... 중요중요중요
        session.setAttribute("vo", vo);
        
        //네비게이션
        response.sendRedirect("BuyServlet");
	}

}
