package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService  phoneService;
	
	@GetMapping("/")//http://127.0.0.1:9999/
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("/regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}
	
	
	@PostMapping("/savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			//성공 페이지
			System.out.println("phoneService.insert....before");
			phoneService.insert(phone);
			System.out.println("phoneService.insert....after");
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
		}catch(Exception e) {
			//에러 페이지
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}
	
	@GetMapping("/searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> phones=phoneService.select();
			model.addAttribute("phones", phones);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 목록 리스트");
			return "PhoneList";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 폰 목록 조회중 에러발생..");
			return "Error";
		}			
	}
	
	@PostMapping("/deleteAjax.do")
	@ResponseBody	
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		
		try {	
			phoneService.delete(num);
			return "";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 폰 삭제 중 에러발생..");
			return "Error";
		}
	}
	
	@GetMapping("/detail.do")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected=phoneService.select(phone);
			model.addAttribute("phone", selected);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세조회");
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 폰 상세 조회 중 에러발생..");
			return "Error";
		}
	}
	
	//////////////////// 로그인  ////////////////////////////////
	@GetMapping("/login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("/login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected=phoneService.select(user);
			if(selected!=null) { //찾는 회원이 있다면...
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 회원 로그인 중 에러발생..");
			return "Error";
		}
	}
	
	
	//rest service 추가
	@GetMapping("/rest.do")
	public String getRestClient() {
		return "rest";
	}

}


























