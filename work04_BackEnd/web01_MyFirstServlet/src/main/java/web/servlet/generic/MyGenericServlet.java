package web.servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * MyGenericServlet 서블릿 클래스는 자바기반으로 만들어진 클래스
 * 자바클래스 --- JVM(Platform) 에서 실행
 * 서블릿    --- Container(WAS, Engine)에서 실행
 * 
 * ::
 * 
 * se와 ee의 차이는 개발자의 객체 생성 가능 여부
 * 
 * MyGenericServlet ms = new MyGenericServlet();
 */
public class MyGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//웹 브라우저로 응답을 하기위한 객체...
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2></h2></body></html>");
		out.println("Hello Generic Servlet~~!!!");
		out.println("</h2></body></html>");
		
		out.close();
	} //클라이언트 응답이 끝났다. == thread, request, response 객체는 메모리에서 내려온다...

}
