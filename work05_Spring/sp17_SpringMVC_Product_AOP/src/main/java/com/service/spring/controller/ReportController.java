package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.aop.model.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("report.do")
	public String selectReport(Model model) throws Exception{
		model.addAttribute("list", reportService.selectReport());
		return "report_result";
	}
	
	
}
