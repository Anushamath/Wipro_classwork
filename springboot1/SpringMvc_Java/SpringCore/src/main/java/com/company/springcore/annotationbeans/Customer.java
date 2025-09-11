package com.company.springcore.annotationbeans;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	Scanner sc = new Scanner(System.in);
	private int id;
	private String name;
	private double salary;
	
	
	public Customer(Scanner sc, int id, String name, double salary) {
		super();
		this.sc = sc;
		this.id = id;
		this.name = name;
		this.salary = salary;
	}


	public void welcomeCustomer()
	{
		
		System.out.println("Annotation Based Config File");
		System.out.println("ID is " + id);
		System.out.println("Name is " + name);
		System.out.println("Salary is " + salary);
	}

}
