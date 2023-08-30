package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MemberVO;
import com.service.spring.model.MemberDAO;
import com.service.spring.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping("find.do")
	public String find(Model model, String id) throws Exception {
		MemberVO rvo = memberService.getMember(id);
		String path = "find_ok";
		
		if(rvo != null) {
			model.addAttribute("vo", rvo);
			model.addAttribute("msg", "회원 발견  - 성공");
			
		} else {
			model.addAttribute("msg", "회원 발견  - 실패");
		}
		
		return path;
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpSession session, MemberVO vo) throws Exception {
		MemberVO rvo = memberService.login(vo);
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다";
		
		if(rvo != null) {
			session.setAttribute("vo", rvo);
			return new ModelAndView("login_result");
		} 
		
		return new ModelAndView("redirect:" + path);
	}
	
	@RequestMapping("logout.do")
	public ModelAndView loginOut(HttpSession session) throws Exception {
		session.invalidate();
		return new ModelAndView("logout");
	}
}
