package com.service.spring.controller;

import java.util.List;

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
    public String login(HttpServletRequest request,MemberVO pvo) throws Exception{

        MemberVO rvo=memberService.login(pvo);
        if(rvo!=null) {
            //login, update는 반드시  session에 값을 바인딩
            request.getSession().setAttribute("vo", rvo);
            return "login_result";
        }else {
            return "redirect:/index.jsp";
        }
    }
	
	@RequestMapping("logout.do")
    public String logout(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("vo")!=null) { //로그인된 상태라면 로그아웃
            session.invalidate();//세션을 죽이고
            return "logout";
        }
        return null;
    }
	
	
	@RequestMapping("idExist.do")
	public String idExist(String id, Model model) throws Exception{
		String rid = memberDAO.idExist(id);
		boolean check = false;
		if(rid != null) {
			check = true;
		}
		model.addAttribute("check",check);
		return "JsonView";
	}
	
	
	@RequestMapping("register.do")
	public String register(MemberVO vo) throws Exception {
		memberDAO.registerMember(vo);
		return "redirect:/showAll.do";
	}
	
	@RequestMapping("showAll.do")
	public String showAll(Model model) throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		//HttpServletRequest에 데이터 바인딩 | 페이지 이동은 forward가 기본을 작동한다.
		model.addAttribute("list",list);
		return "allView";
	}
	
	@RequestMapping("update.do")
    public String update(HttpSession session, MemberVO pvo) throws Exception{
        //로그인된 상태에서만 수정 가능...
        if(session.getAttribute("vo")!=null) {//로그인 상태라면
          memberDAO.updateMember(pvo);
          session.setAttribute("vo", pvo);
          return "update_result";
        }
        
        return null;
    }
}
