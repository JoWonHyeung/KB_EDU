package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String greet; //서비스 직전에 받아와야함... 화면으로부터 못받아옴...init활용

    public GreetingServlet() {
    	System.out.println("1. GreetingServlet 디폴트로 생성...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. GreetingServlet 필드 초기화");
    	greet = getInitParameter("GREET");
    	System.out.println("" + greet);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리...로직은 여기서 작성... 클라이언트 요청 시점에 호출... 폼값 받아온다...
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        System.out.println("3. doProcess... 클라이언트 요청시 동작함...");
        String name = request.getParameter("name");
        
        PrintWriter out = response.getWriter();
        out.println("<body>"
        		+ "<h3>" + name + ", " + greet + "</h3>"); // greet : ready on 상태에서 받아온 값. 컨테이너 차원에서 설정한 정보. 서블릿 필드 초기화
        												   // name : 클라이언트 요청시 받아온 값. 폼값 받아서 화면에 출력.
        out.close();
	}

}
