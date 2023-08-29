package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
		/*
		 * login로직을 호출
		 * 1. userService의 login()
		 * 2. 반환된 값이 있다면...세션에 바인딩
		 * 3. 네비게이션
		 */
		
		User rvo = userService.login(user);
		System.out.println("rvo :: " + rvo);
		
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다";
		if(rvo != null) { ///로그인 성공햇다면.. 세션에 정보를 바인딩
			request.getSession().setAttribute("user", rvo);
			
			msg = "정상적으로 로그인 되었습니다";
		}
		
		request.getSession().setAttribute("msg", msg); //로그인 성공여부에 따라서 메세지가 달라진다.
		
		return new ModelAndView("redirect:" + path); //resolver랑 전혀 상관없다... 방향을 바로 틀어버린다...
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		session.invalidate();
		return new ModelAndView("redirect:index.jsp");
	}
	
}
