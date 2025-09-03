package com.wipro.file;



//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class EmployeeManagerData {
	
	private static final Path Dir = Paths.get("FileData");
	private static final Path File = Dir.resolve("employee.txt");

	private static final Scanner sc = new Scanner(System.in);
	
	private static List<Employee> list = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		
		
		Files.createDirectories(Dir);
		if(!Files.exists(File))
			Files.createFile(File);
		
		while(true)
		  {
		   System.out.println("\n1.Add , 2.Delete , 3. Search , 4. View All , 5. save&Exit");
		   int choice = sc.nextInt();
		   switch(choice)
		   {
		   case 1  -> addEmployee();
		  // case 2 -> deleteEmployee();
		  // case 3 -> searchEmployee();
		   case 4-> viewAll();
		   case 6 -> {Save_Exit(); return;}
		   
		   }
		  }
		

	}
	
	
//	private static void loadFromFile() 
//	{
//		
//		
//		
//	}
	
	private static void addEmployee()
	{
		try(BufferedWriter writer = Files.newBufferedWriter(File, StandardOpenOption.APPEND))
		{
		System.out.println("id , name and Salary");
		//list.add(new Employee(sc.nextInt() , sc.next(), sc.nextDouble()));
	   Employee e = new Employee(sc.nextInt() , sc.next(), sc.nextDouble());
		writer.write(e.toString());
		System.out.println("Employee Added");
				
	}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
		
}
	private static void viewAll()
	{
		try(BufferedReader reader = Files.newBufferedReader(File))
		{
		System.out.println("Data from files");
		String line;
		boolean found = false;
		while((line = reader.readLine()) != null)
		{
			System.out.println(line);
		
		}
		
	    
		
				
	}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}

}
	
	private static void Save_Exit()
	{
		
		return;
	}
	
	private static void deleteEmployee() {
	    System.out.println("Enter the ID of the employee to delete:");
	    int idToDelete = sc.nextInt();
	    sc.nextLine(); // Consume newline left-over

	    boolean found = false;
	    for (Employee emp : list) {
	        if (emp.getId() == idToDelete) {
	            list.remove(emp);
	            found = true;
	            break;
	        }
	    }

	    if (found) {
	        System.out.println("Employee with ID " + idToDelete + " has been deleted.");
	        // This is a simple implementation, a more efficient way would be to
	        // rewrite the file.
	        try (BufferedWriter writer = Files.newBufferedWriter(File)) {
	            for (Employee emp : list) {
	                writer.write(emp.toString());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.err.println(e.getMessage());
	        }
	    } else {
	        System.out.println("Employee with ID " + idToDelete + " not found.");
	    }
	}
	
	
}

