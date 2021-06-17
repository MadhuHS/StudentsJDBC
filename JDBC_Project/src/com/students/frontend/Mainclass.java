package com.students.frontend;

import java.sql.SQLException;

import com.students.dao.StudentDaoImpl;
import com.students.entity.Student;

public class Mainclass
{
	public static void main(String[] args) 
	{
		  System.out.println("Main starts...");
		  Student std = new Student(0,"MSD","MSD@csk.com","7654681293");
		  
		  StudentDaoImpl sdi = new StudentDaoImpl();
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
		  System.out.println("Main ends...");

	}
}
