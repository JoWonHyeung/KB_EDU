package servlet.controller;

//Controller를 생성하는 공장...
//많은 Controller 생성하더라도 공장은 오직 한개만 필요... 싱글톤
public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	//FrontController가 전해주는 command값에 따라서 생성되는 Controller가 달라진다
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find")){
			controller= new FindController();
			System.out.println("FindController 생성...");
		}else if(command.equals("login")) {
			controller= new LoginController();
			System.out.println("LoginController 생성...");
		}else if(command.equals("showAll")) {
			controller= new ShowAllController();
			System.out.println("ShowAllController 생성...");
		}else if(command.equals("register")) {
			controller= new RegisterController();
			System.out.println("RegisterController 생성...");
		}else if(command.equals("logout")) {
			controller= new LogoutController();
			System.out.println("LogoutController 생성...");
		}else if(command.equals("update")) {
			controller= new UpdateController();
			System.out.println("UpdateController 생성...");
		}
		
		return controller;
	}
}
