package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FrontController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO리턴받고... 비지니스 로직 호출
		 * 4. 반환값 바인딩..
		 * 5. 네비게이션
		 * 
		 * 1~4번까지 했다치고 5번만 진행한다.
		 * String ---> ModelAndView
		 */
		
		
		/*
		 [ModelAndView 역할]
		 1. request 바인딩
		 2. result.jsp 페이지로 forward된다.
		 
		 
		 결과 페이지가 저장된 물리적 위치, 즉 경로를 모른다.
		 결과페이지의 확장자를 알 수 없다... jsp인지 ..php인지.. html인지...
		 */
		return new ModelAndView("result", "message", "Hello First Spring MVC Framework"); //view page 이름만 적는다... 
	}

}
