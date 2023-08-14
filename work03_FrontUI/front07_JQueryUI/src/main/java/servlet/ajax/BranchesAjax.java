package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BranchesAjax")
public class BranchesAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BranchesAjax() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("...doGet BranchesAjax...진입함...");
		
		String result = "<ul>" +
					"<li> 국민은행 서초 지점 </li>" +
					"<li> 국민은행 선릉 지점 </li>" + 
					"<li> 국민은행 역삼 지점 </li>" + 
					"<li> 국민은행 강북 지점 </li>" + 
					"<li> 국민은행 가디 지점 </li>" + 
					"<li> 국민은행 용산 지점 </li>" +
					"</ul>";
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}


}
