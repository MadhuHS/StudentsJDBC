package com.jspiders.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.students.entity.Student;

public class MysqlDB 
{
	private final String dbUrl = "jdbc:mysql://127.0.0.1:3306/";
	private final String username = "root";
	private final String password = "root";
	private Connection con = null;//SingleTon 
    
	public Connection getDBConnection(String schemaName) throws SQLException
    {
		 if(con == null)
		 {
		  con = DriverManager.getConnection(dbUrl+schemaName,username,password);	
		  System.out.println("Connection open"); 
		 } 
		 return con;
    }
	
	public int insert(Student std) throws SQLException
	{
		  String insertQuery = "insert into StudentsDB.Student values(?,?,?,?);";	
		  getDBConnection("StudentsDB");
		  
		  PreparedStatement psm =  con.prepareStatement(insertQuery);
		 
		  psm.setInt(1,0);
		  psm.setString(2,std.getName());
		  psm.setString(3,std.getEmail());
		  psm.setString(4,std.getMob());
		  
	      
          /*executeUpdate() :Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement 
	        or an SQL statement that returns nothing, such as an SQL DDL statement.*/
	      
	      int count = psm.executeUpdate();
	      return count;

	}
	
	public Student selectByEmail(String email)throws SQLException
	{
		String selectQuery = "select * from StudentsDB.Student where email = ?";
		getDBConnection("StudentsDB");
		
		PreparedStatement psm = con.prepareStatement(selectQuery);
		psm.setString(1, email);
		
		ResultSet rs = psm.executeQuery();//exectute Select query and copy the result to ResultSet
		rs.next();//move the cursor to first record/row
		
		String  name   = rs.getString("name");
		String  sEmail = rs.getString("email");
		String  mob    = rs.getString("mob");
		
		Student std = new Student(name,sEmail,mob);
		return std;
	}
	
	public int updateEmail(String email)
	{
		int count = 0;
		
		return count;
	}
	
	public int deleteByEmail(String email)
	{
		int count = 0;
		
		return count;
	}
	
	
	public void disconnect() throws SQLException 
    {
		con.close();
		  System.out.println("Connection closed"); 

    }
	
	
}
