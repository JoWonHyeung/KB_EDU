package com.service.spring.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public String insert(MyProduct pvo, Model model) throws Exception{			
		model.addAttribute("vo", myProductService.addProduct(pvo));
		return "insert_result";
	}
	
	@RequestMapping("productSearch.do")
	public String findByProductName(String word, Model model)throws Exception{		
		
		System.out.println("ProductController...findByProductName() :: "+word);	
		model.addAttribute("list", myProductService.findByProductName(word));
		return "find_result";
	}	
}
