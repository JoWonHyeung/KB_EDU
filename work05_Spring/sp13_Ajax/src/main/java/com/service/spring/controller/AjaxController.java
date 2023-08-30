package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	
	//Autowired... Service... 생략
	
	@RequestMapping("/") //http://127.0.0.1:8888/spring ... spring은 maven의 artifactId
	public String index() {
		System.out.println("context path recalling...");
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro") //http://127.0.0.1:8888/spring ... spring은 maven의 artifactId
	public String synchro(Model model) {
		System.out.println("synchro request");
		
		//ServletRequest에 바로 바인딩... forward방식으로 이동
		model.addAttribute("info","와~~~동기통신~~~");
		
		return "synchro_result";
	}
	
	@RequestMapping("asynch") //http://127.0.0.1:8888/spring ... spring은 maven의 artifactId
	public String asynch(Model model) {
		System.out.println("asynch request");
		
		//ServletRequest에 바로 바인딩... forward방식으로 이동
		model.addAttribute("person",new Person("김국민","역삼동"));
		
		return "JsonView"; //여기선 InternalResourceViewResolver방식이 안통한다...
	}
	
}
