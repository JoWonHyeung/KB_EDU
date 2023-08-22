package web.controller;

public class UpdateController implements Controller {

	@Override
	public String handleRequest() {
		/*
		 1~5 Controller의 역할
		 MVC Pattern(서블릿마다 해당 코드가 작성)
		 Front Controller Pattern(메소드 단위 마다에서 작성)
		 Factory Method Pattern(인터페이스 상속받은 자바 클래스에서 작성)
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. dao리턴받고
		 * 4. biz logic 호출
		 * 5. 네비게이션
		 */
		System.out.println("UpdateController...Update Member..");
		return "update_result.jsp";
	}

}
