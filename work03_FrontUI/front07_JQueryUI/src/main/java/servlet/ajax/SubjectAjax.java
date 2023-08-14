package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectAjax")
public class SubjectAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubjectAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//디비 연결했다치고....
		
		System.out.println("...doGet SubjectAjax...진입함...");
		String result = "JAVA | JDBC | BootStrap | Spring Framework | AI";
	
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Result.jsp").forward(request, response);
		
	}

}
