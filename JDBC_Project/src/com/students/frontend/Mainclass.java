package com.students.frontend;

import java.sql.SQLException;

import com.students.dao.StudentDaoImpl;
import com.students.entity.Student;
import java.util.Scanner;

public class Mainclass
{
	static final Scanner scn = new Scanner(System.in);
	static final StudentDaoImpl sdi = new StudentDaoImpl();


	public static void addStudent()
	{
		//add student
		 System.out.println("enter name");
		 String name = scn.next();
		
		 System.out.println("enter email");
		 String email = scn.next();
		
		 System.out.println("enter mobile no");
		 String mob = scn.next();
		 
		 Student std = new Student(name,email,mob);
		  
		  
		  try 
		  {
			sdi.createStudent(std);
		  } 
		  catch (SQLException e)
		  {
		    System.out.println();
			System.out.println("OOPS!!! Error while adding "+std.getName());
		    System.out.println();

		  } 
	}
	
	public static void viewStudent()
	{
		System.out.println("Please enter registed email-ID");
		String email =	scn.next();
		try 
		{
			Student std = sdi.getStudentByEmai(email);
			
			System.out.println(std.toString());
		} 
		catch (SQLException e) 
		{
			System.out.println("Oops!! student with email id : "+email+" does not exists");
		}
		
		
	}
	
	public static void menu()
	{
		 while(true)
		 {
		 
		 System.out.println("1. add student");
		 System.out.println("2. view student");
		 System.out.println("3. update student email");
		 System.out.println("4. update student mob");
		 System.out.println("5. delete student");
		 System.out.println("Any key to exit");
		 
		 int optn = scn.nextInt();
		 
		 switch(optn)
		 {
		    case 1  : addStudent(); 
		              break;
		    
		    case 2  : viewStudent(); 
                      break;
                      
		    default : System.out.println("Thank you see you again"); 
		    	      System.exit(0);//stop the application         
		 }
		 
		 }
  
	}
	
	public static void main(String[] args) 
	{
		  System.out.println("Main starts...");
		  
		  menu();
		  
		
		  System.out.println("Main ends...");

	}
}






