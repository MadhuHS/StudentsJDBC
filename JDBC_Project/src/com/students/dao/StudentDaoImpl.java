package com.students.dao;

import java.sql.SQLException;

import com.jspiders.db.MysqlDB;
import com.students.entity.Student;

public class StudentDaoImpl implements StudentDAO 
{
	private MysqlDB db = new MysqlDB();
	
	@Override
	public void createStudent(Student std) throws SQLException
	{
	   int count = db.insert(std);
	   if(count > 0)
	   {
		   System.out.println(std.getName()+" was created");
	   }
	}

	@Override
	public void getStudentById(Integer id)
	{
		
	}

	@Override
	public void updateStudentEmail(Integer id, String newEmail)
	{
		
	}

	@Override
	public void deleteStudent(Integer id)
	{
		
	}

	@Override
	public void getAllStudents()
	{
		
	}
}
