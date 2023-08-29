package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.BookDAO;
import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void insertBook(Book vo) throws Exception {
		bookDAO.insertBook(vo);
	}

	@Override
	public List<Book> getBooks() throws Exception {
		return bookDAO.getBooks();
	}

	@Override
	public List<Book> searchByTitle(String word) throws Exception {
		return bookDAO.searchByTitle(word);
	}

	@Override
	public List<Book> searchByPublisher(String word) throws Exception {		
		return bookDAO.searchByPublisher(word);
	}

	@Override
	public List<Book> searchByPrice(int price) throws Exception {
		return bookDAO.searchByPrice(price);
	}

	@Override
	public Book searchByIsbn(String word) throws Exception {
		return bookDAO.searchByIsbn(word);
	}

	@Override
	public void delete(String word) throws Exception {
		bookDAO.delete(word);		
	}

	@Override
	public Book getIsbn(String word) throws Exception {		
		return bookDAO.getIsbn(word);
	}

	@Override
	public void update(Book vo) throws Exception {
		bookDAO.update(vo);
		
	}
}
