package com.edu.service;


import java.util.ArrayList;
import java.util.List;

import com.edu.exception.ISBNNotFoundException;
import com.edu.exception.QuantityException;
import com.edu.parent.Book;

public class BookServiceImpl implements BookService {
	private ArrayList<Book> list;
	
	private static BookServiceImpl mgr = new BookServiceImpl();

	private BookServiceImpl() {
		list = new ArrayList<Book>();
	}

	public static BookServiceImpl getInstance() {
		return mgr;
	}
	
	@Override
	public void add(Book b) {
		boolean flag = false;
		
		for(Book book : list) {
			if(book.getIsbn().equals(b.getIsbn())) {
				System.out.println("해당 책이 이미 존재합니다.");
				flag = true;
				break;
			}
		}
		
		if(!flag) list.add(b); 
	}

	@Override
	public List<Book> search() {
		return list;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		boolean flag = false;
		
		for(Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				flag = true;
				if(book.getQuantity() >= quantity) 
					book.setQuantity(book.getQuantity() - quantity);
				else 
					throw new QuantityException(); //요청 수량이 더 많을 경우
				break;
			}
		}
		
		if(!flag) throw new ISBNNotFoundException(); //해당 책을 찾지 못했을 경우
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		boolean flag = false;
		
		for(Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				flag = true;
				book.setQuantity(book.getQuantity() + quantity);
				break;
			}
		}
		
		if(!flag) throw new ISBNNotFoundException();
	}

	@Override
	public int getTotalAmount() {
		int temp = 0;
		for(Book book : list) 
			temp += book.getPrice() * book.getQuantity();
		
		return temp;
	}

}
