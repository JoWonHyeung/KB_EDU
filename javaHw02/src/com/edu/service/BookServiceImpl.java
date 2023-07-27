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
		System.out.println("������ ȣ��");
		list = new ArrayList<Book>();
	
	}

	public static BookServiceImpl getInstance() {
		return mgr;
	}

	@Override
	public void add(Book b) {
		
		//����Ʈ�� book�� �߰�
	}

	@Override
	public List<Book> search() {
		//��� book�� ��ȯ
		return null;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		
			/*
			   1.�ȷ��� å�� ������ ��� �����ϴٸ� QuantityException ���ܸ� �߻�
			   2.�ȷ��� å�� �ְ� ��� �˳��ϴٸ� ������ ������ ������Ʈ��
			   3.�ȷ��� å�� isbn�� �߰����� ���ϸ� ISBNNotFoundException ���ܸ� �߻�
			*/
			
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		/*
		  1. �����Ϸ��� isbn�� ã���� ������ ISBNNotFoundException ���ܸ� �߻�
		  2. �����Ϸ��� isbn�� �ִٸ� �� å�� ������ ������Ʈ ��Ŵ
		 
		 */		
	}

	@Override
	public int getTotalAmount() {
		// �������� ��� å�� �� ���ݱݾ��� ��ȯ
		return 0;
	}

}
