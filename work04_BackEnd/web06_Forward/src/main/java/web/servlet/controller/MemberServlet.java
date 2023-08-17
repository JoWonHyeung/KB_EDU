package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dto.Member;

@WebServlet("/Find")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //1. 폼값 받아서
        //2. DAO리턴받고... 비지니스 로직 호출
        //3. 디비 리턴된 값 반환
        //4. 값을 바인딩(Attribute)
        //5. 페이지 이동(네비게이션)
        String address = request.getParameter("address");
        
        Member member1 = new Member("아이유","여의도",30);
        
        request.setAttribute("member1", member1); // 객체 이름과 key값을 일치시킨다...컨벤션이다... 따라서해라
        
        //이때 서버상에서 페이지가 직접 이동한다...
        //현재 모든 권한을 가지고 이동한다...
        request.getRequestDispatcher("result.jsp").forward(request, response);
        
       
//        PrintWriter out = response.getWriter();
//        out.println("<h3>Result Page</h3>");
//        out.println("<h4><a href=result.jsp>여기를 클릭하면 JSP 연결됩니다..</a></4>"); 
	}

}


