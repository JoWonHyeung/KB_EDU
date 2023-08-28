package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController { //POJO 기반 : Play Old Java Object
	
	@RequestMapping("/form.do")
	public ModelAndView form(String myName, String myAddr) {
		/*
		 * 폼값 받아서 
		 * 비지니스 로직 호출
		 * 반환값 바인딩
		 * 네비게이션
		 */
		return new ModelAndView("/WEB-INF/views/form_result.jsp", "info", myName + "님이 사는 곳은 " + myAddr);
	}
}
