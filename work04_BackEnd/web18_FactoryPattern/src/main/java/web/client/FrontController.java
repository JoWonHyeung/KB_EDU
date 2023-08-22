package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.factory.ControllerFactory;

/*
 * 나중에 서블릿 역할
 * FrontController가 된다
 */
public class FrontController {

	public static void main(String[] args) {
		//브라우저 폼에서 받은 값을....
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>> Command 값 입력");
		
		String command = sc.next();
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		controller.handleRequest();
	
	}
}
