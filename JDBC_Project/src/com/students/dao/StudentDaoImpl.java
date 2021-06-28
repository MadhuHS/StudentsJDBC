package com.students.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.jspiders.db.MysqlDB;
import com.students.entity.Student;

public class StudentDaoImpl implements StudentDAO 
{
	private MysqlDB db = new MysqlDB();
	
	@Override
	public void openApp() throws SQLException
	{
       db.setDBConnection();		
	}
	
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
	public void createMultipleStudents(Set<Student> studentSet) throws SQLException 
	{
		db.insertMultiple(studentSet);
	}
	
	@Override
	public Student getStudentByEmai(String email) throws SQLException 
	{
		Student std= db.selectByEmail(email);
		return std;
	}

	@Override
	public void getStudentById(Integer id)
	{
		//assignment
	}

	@Override
	public void updateStudentEmail(String curEmail, String newEmail) throws SQLException
	{
	  db.updateEmail(curEmail, newEmail);
	}

	@Override
	public void deleteStudent(Integer id)
	{
		//assignment

	}

	@Override
	public List<Student> getAllStudents() throws SQLException
	{
		List<Student> studentList = db.selectAll();
		return studentList;
	}

	@Override
	public void closeApp() throws SQLException
	{
		db.disconnect();		
	}
	
}
