package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception {
		List<Book> list = bookService.getBooks();
		
		return new ModelAndView("book/bookList","list",list);
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(Book book, HttpServletRequest request, HttpSession session) 
							throws Exception {
		System.out.println("register BookVO before:: "+book);//null

        String isbn1 = request.getParameter("isbn1").trim();
        String isbn2 = request.getParameter("isbn2").trim();
        String isbn3 = request.getParameter("isbn3").trim();
        book.setIsbn(isbn1+"-"+isbn2+"-"+isbn3);

        System.out.println("register BookVO after:: "+book); //?

        String msg = "";
        String path = "Error.jsp";
        try {
            bookService.insertBook(book);//정상적으로 book이 add 되었다.
            // 디비에 성공적으로 등록을 하면 다시 이곳으로 리턴된다.
            msg = "책 정보가 정상적으로 디비에 저장되었습니다.";
            path = "result.jsp";

        }catch(Exception e) {
            // 디비에 성공적으로 등록을 하지 못했다면 이곳으로 리턴된다.
            System.out.println(e);
            msg = "책 정보 저장중 오류 발생...";
        }
        //바인딩
        session.setAttribute("msg", msg); //페이지 이동 방법
        return new ModelAndView("redirect:"+path);
	}
	
	@RequestMapping("bookSearch.do")
    public ModelAndView search(String searchField ,String searchText, HttpServletRequest request) 
    						throws Exception{  
		String path =  "book/bookList";
		List<Book> list = null;
		
		try {
			switch(searchField) {
				case "TITLE":
					//searchByTitle()....
					list = bookService.searchByTitle(searchText);
					break;
				case "PUBLISHER":
					//searchByPublisher()...
					list = bookService.searchByPublisher(searchText);
					break;
				case "PRICE":
					//searchByPrice()...
					list = bookService.searchByPrice(Integer.parseInt(searchText));
					break;
				default:
					//getBooks()...
					list = bookService.getBooks();
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path,"list",list);
	}
	
	@RequestMapping("bookView.do")
	public ModelAndView bookview(String isbn, HttpServletRequest request)
							throws Exception{
		//searchByIsbn() ... book/bookView
		String path = "Error";
		Book book = null;
		
		try {
			book = bookService.searchByIsbn(isbn);
			path = "book/bookView";
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path,"b",book);
	}
	
	@RequestMapping("bookDesc.do")
	public ModelAndView desc(String isbn, HttpServletRequest request) {
		Book book = null;
		
		try {
			book = bookService.getIsbn(isbn);
			System.out.println(book);
		}catch(Exception e) {
			request.setAttribute("msg", "비동기 통신 오류 발생");
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("JsonView","book",book);
	}
	
}
