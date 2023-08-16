package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* web.xml(일종의 주문서)
 * <servlet>
 * 		<servlet-name>LoginFormServlet</servlet-name>
 * 		<servlet-class>web.servlet.http.LoginFormServlet</servlet-class>
 * <servlet>
 * 
 * <servlet-mapping>
 * 		<servlet-name>LoginFormServlet</servlet-name>
 * 		<url-pattern> /LFS </url-pattern>
 * </servlet-mapping>
 */
@WebServlet("/LFS") //어노테이션
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리... PrintWriter 리턴 받기 전에 작성해야 한다... | 2. 양방향 다해줘야 한다...
		request.setCharacterEncoding("utf-8"); //이게 먹을려면 server.xml에서 URIEncoding을 utf-8로 설정해야한다...
        response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter(); 
		out.println("<html><body>");
		out.println("<ul>"
				+ "<li> ID : " + id + "</li>"
				+ "<li> PASSWORD : " + password + "</li>"
					+ "</ul>");
		out.println("</body></html>");		
		
		out.close();
	}
	
}
