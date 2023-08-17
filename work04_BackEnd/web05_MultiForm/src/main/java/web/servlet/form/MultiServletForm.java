package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class MultiServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MultiServletForm() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
	
        PrintWriter out = response.getWriter();
        
        out.println("<h2>Get방식 요청에 대한 응답 내용입니다.</h2>");
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        
        out.println("<li>" + id + "</li>");
        out.println("<li>" + name + "</li>");
        
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String[] teches = request.getParameterValues("tech");
        
        PrintWriter out = response.getWriter();
        
        out.println("<h2>폼값에 입력된 정보들 입니다.</h2>");
        out.println("<li>아이디 : "+id+"</li>");
        out.println("<li>패스워드 : "+password+"</li>");
        out.println("<li>성별 : "+gender+"</li><br>");

        out.println("<b> 사용기술입니다.</b><br>"); 
        String tech = ""; 
        
        for(String t : teches) {
           tech += t+" "; 
           out.println(tech);
        }
        
        out.close();
        
	}

}
