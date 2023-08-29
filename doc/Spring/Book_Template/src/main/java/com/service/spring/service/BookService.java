package com.service.spring.service;

import java.util.List;
import com.service.spring.domain.Book;

public interface BookService {
	
	void insertBook(Book vo) throws Exception;
	public List<Book> getBooks() throws Exception;
	List<Book> searchByTitle(String word) throws Exception;
	List<Book> searchByPublisher(String word) throws Exception;
	List<Book> searchByPrice(int price) throws Exception;
	Book searchByIsbn(String word) throws Exception;
	void delete(String word) throws Exception;
	Book getIsbn(String word) throws Exception;
	void update(Book vo) throws Exception;
}
