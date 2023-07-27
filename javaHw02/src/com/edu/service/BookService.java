package com.edu.service;

import java.util.List;

import com.edu.exception.ISBNNotFoundException;
import com.edu.exception.QuantityException;
import com.edu.parent.Book;

public interface BookService {
	void add(Book b);
	List<Book> search();
	void sell(String isbn,int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();

	

}
