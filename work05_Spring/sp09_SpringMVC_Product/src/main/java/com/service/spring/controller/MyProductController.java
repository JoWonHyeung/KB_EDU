package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct pvo) throws Exception{ //vo에도 자동바인딩이 되는구나..?
		System.out.println("addProduct 호출 전 pvo ::: "+pvo); //0,세탁기,대우,50 (sequence 값은 들어가지 않는다)
		myProductService.addProduct(pvo);
		System.out.println("addProduct 호출 후 pvo ::: "+pvo); //sequence 값 추가 완료
		return new ModelAndView("insert_result", "vo", pvo); //pvo를 바인딩 하는 이름은 vo로!!
	}
	
	@RequestMapping("/myProductSearch.do")
    public ModelAndView find(String command, String word) throws Exception{
        List<MyProduct> list = null;
        String viewName = "";
        if(command.equals("findProductByName")) {
            list=myProductService.findProductByName(word);
            viewName = "find_result"; //결과페이지는 같지만 내용은 다르게 바인딩된다.
        }else if(command.equals("findProductByMaker")) {
            list=myProductService.findProductByMaker(word);
            viewName = "find_result";
        }else if(command.equals("findProducts")) {
            list=myProductService.findProducts();
            viewName = "find_result";
        }
        return new ModelAndView(viewName,"list",list);

    }
}
