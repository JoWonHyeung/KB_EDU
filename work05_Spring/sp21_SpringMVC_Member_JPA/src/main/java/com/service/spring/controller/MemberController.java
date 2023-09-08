package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService  memberService;
	
	@RequestMapping("findMember.do")
	public String findMember(Model model, String id) {
		System.out.println("findMember...controller..");
		Member vo = memberService.findByIdMember(id);
		
		System.out.println("findMember...controller..vo"+ vo);
		model.addAttribute("vo", vo);
		if(vo!=null) return "find_ok";
		else return "find_fail";
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, Member member) {
		System.out.println("login...controller 진입..");
		Member vo = memberService.login(member);
		HttpSession session = request.getSession();
		if(vo!=null) {
			session.setAttribute("vo", vo);
			return "login_result";
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("register.do")
	public String register(String id, String password, String name, String address) {
		memberService.registerMember(new Member(id, password, name, address));
		return "redirect:/allMember.do";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "logout";
		}
		return null;
	}
	
	@RequestMapping("allMember.do")
	public String allMember(Model model) {
		List<Member> list = memberService.showAllMember();
		model.addAttribute("list", list);
		return "allView";
	}
	
	@RequestMapping("update.do")
	public String update(HttpServletRequest request, String id, String password, String name, String address) {
		Member vo = new Member(id, password, name, address);
		memberService.updateMember(vo);
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo); 
		}
		return "update_result";
	}
	
	@RequestMapping("idExist.do")
	public String idExist(Model model, String id) {
		String idExist = memberService.idExist(id);
		boolean check = false;
		if(idExist!=null) check = true;
		model.addAttribute("check", check);
		return "JsonView";
	}
	
}
