package com.edu.bank.test;

import java.util.Scanner;

import com.edu.bank.Account;
import com.edu.bank.Bank;


public class BankTest {
	public static Bank bank = new Bank();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.고객 등록    2.계좌생성    3.은행업무    4.고객전체명단    5.특정고객정보    6.나가기");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				addCustomer();
				break;
			case 2:
				addAccount();
				break;
				
			case 3:
				banking();
				break;
			case 4:
				bank.showAll();
				break;
			case 5:
				showCustomer();
				break;
			case 6:
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
		
	}
	
	public static void addCustomer() {
		System.out.println("[ 이름  주민등록번호 우편번호 도(행정구역) 지역명 ]순으로 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int rrn = sc.nextInt();
		int zipCode = sc.nextInt();
		String region = sc.next();
		String city = sc.next();
		
		bank.addCustomer(name, rrn, zipCode, region, city);
		System.out.println(name + "님 회원등록 성공했습니다.");
		
	}
	
	public static void addAccount() {
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int rrn = sc.nextInt();
		
		int balance = 0;
		if(bank.getCustomer(rrn).getName() != "") {
			System.out.print("개설할 통장의 잔액을 입력하세요 : ");
			balance = sc.nextInt();
			
			bank.getCustomer(rrn).setAccount(new Account(balance));
		}else {
			System.out.println("존재하는 회원이 없습니다.");
			return;
		}
	}

	public static void showCustomer() {
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int rrn = sc.nextInt();
		
		if(bank.getCustomer(rrn).getName() != "") {
			System.out.println(bank.getCustomer(rrn));
		}else {
			System.out.println("존재하는 회원이 없습니다.");
			return;
		}
	}
	
	public static void banking() {
		System.out.print("회원의 주민번호를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int rrn = sc.nextInt();
		
		if(bank.getCustomer(rrn).getName() == "") {
			System.out.println("존재하는 회원이 없습니다.");
			return;
		}
		
		if(bank.getCustomer(rrn).getAccount() == null) {
			System.out.println("통장개설부터 하세요.");
			return;
		}
		
		while(true) {
			System.out.println("1.입금    2.출금    3.잔액확인    4.나가기");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				deposit(rrn);
				break;
				
			case 2:
				withdraw(rrn);
				break;
			case 3:
				showBalance(rrn);
				break;
			case 4:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public static void deposit(int rrn) {
		System.out.print("입금할 금액을 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		
		bank.getCustomer(rrn).getAccount().deposit(amt);
		System.out.println(bank.getCustomer(rrn).getAccount());
	}
	
	public static void withdraw(int rrn) {
		System.out.print("출금할 금액을 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		
		bank.getCustomer(rrn).getAccount().withdraw(amt);
		System.out.println(bank.getCustomer(rrn).getAccount());
	}
	
	public static void showBalance(int rrn) {
		System.out.println(bank.getCustomer(rrn).getAccount());
	}
	
}
