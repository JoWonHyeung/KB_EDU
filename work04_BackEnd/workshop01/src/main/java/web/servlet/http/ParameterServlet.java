package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ParameterServlet() {
    	System.out.println("ParameterServlet...");

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ParameterServlet doGet...");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ParameterServlet doPost...");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("GET")) {
			String job = request.getParameter("job");
			String pageNo = request.getParameter("pageNo");
			String searchWord = request.getParameter("searchWord");
			
			PrintWriter out = response.getWriter();
			out.println("<body>"
					+ "<p> job : " + job + "</p>"
					+ "<p> pageNo : " + pageNo + "</p>"
					+ "<p> searchWord : " + searchWord + "</p>");
			
			out.close();
		}else if(request.getMethod().equals("POST")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String hobbys = "";
			String fav = request.getParameter("favorite");
			String desc = request.getParameter("desc");
			
			for(String hobby : request.getParameterValues("hobby")) hobbys += hobby + ", ";
			
			PrintWriter out = response.getWriter();
			
			out.println("<body>"
					+ "<p> job : " + name + "</p>"
					+ "<p> email : " + email + "</p>"
					+ "<p> gender : " + gender + "</p>"
					+ "<p> hobby : " + hobbys.substring(0, hobbys.length() - 2) + "</p>"
					+ "<p> favorite : " + fav + "</p>"
					+ "<p> desc : " + desc + "</p>"
					+ "</body>");
			
		}
	}

}
