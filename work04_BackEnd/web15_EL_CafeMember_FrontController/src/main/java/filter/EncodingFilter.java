package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

public class EncodingFilter implements Filter {
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//공통적으로 처리해야 할 로직... 모든 서블릿에서 
		//한글처리 
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");

	    //서버상에서 다음 컴포넌트 프로그램에 계속적으로 필터링한 공통 로직이 적용된다.
	    //이 부분을 빠뜨리면 공통로직을 필터링에 정의만 했기 때문에 실질적으로 처리되지 않는다. 반드시 넣어야 한다.
	    chain.doFilter(request, response);

	}

}
