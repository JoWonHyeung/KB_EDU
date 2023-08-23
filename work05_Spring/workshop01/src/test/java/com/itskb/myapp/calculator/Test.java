package com.itskb.myapp.calculator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/config/interest-calculator.xml");
		
		
		InterestCalculatorService interestCalculatorService = (InterestCalculatorService) context.getBean("interestCalculatorService");
		int amount = 100_000_000;
		double loanInterest = interestCalculatorService.calculateLoanInterest(amount);
		System.out.printf("Amount : %10d loanInterest is %.2f", amount, loanInterest);
		
		System.out.println();
		
		double savingInterest = interestCalculatorService.calculateSavingInterest(amount);
		System.out.printf("Amount : %10d savingInterest is %.2f", amount, savingInterest);
		System.out.println();
		context.close();
	}

}
