package com.service.spring.dao;

import java.util.List;
import com.service.spring.domain.Book;

public interface BookDAO {

	void insertBook(Book book) throws Exception;

	List<Book> getBooks() throws Exception;

	List<Book> searchByTitle(String title) throws Exception;

	List<Book> searchByPublisher(String publisher) throws Exception;

	List<Book> searchByPrice(int price) throws Exception;

	Book searchByIsbn(String isbn) throws Exception;
	
	Book getIsbn(String word) throws Exception;

	void delete(String isbn) throws Exception;
	void update(Book vo) throws Exception;
}