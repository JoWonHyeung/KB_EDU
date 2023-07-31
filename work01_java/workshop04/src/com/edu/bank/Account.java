package com.edu.bank;

public class Account { //14번에서 가져오기
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
		System.out.println("���������� ���尳���Ͽ����ϴ�.");
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) {
		if(amt < 1000) {
			System.out.println("1000�̻� �Ա��ؾ� �մϴ�.");
		}else {
			balance+=amt;
		}
	}
	
	public void withdraw(int amt) {
		if(amt > balance) {
			System.out.println("�ܾ��� �����մϴ�.");
		}else {
			balance-=amt;
		}
	}
	
	@Override
	public String toString() {
		return "���� �ܾ��� " + balance + "���Դϴ�.";
	}
	
}
