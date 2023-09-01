package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String doHello(Model model) {
		model.addAttribute("data","Hello Spring Start~~~!!");
		return "result";
	}
	
}
