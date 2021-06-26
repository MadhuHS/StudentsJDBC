package com.jspiders.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.students.entity.Student;

public class MysqlDB {
	private final String dbUrl = "jdbc:mysql://127.0.0.1:3306/";
	private final String username = "root";
	private final String password = "root";
	private Connection con = null;// SingleTon
	private PreparedStatement psm = null;
	
	private final String insertQuery = "insert into StudentsDB.Student values(?,?,?,?);";
	private final String selectByEmailQuery = "select * from StudentsDB.Student where email = ?";
	private final String updateQuery = "update StudentsDB.Student set email = ?  where email = ?";
	private final String selectQuery  = "select * from StudentsDB.Student;";
	private final String countRecords = "select count(*) from StudentsDB.Student;";


	private final String schemaName = "StudentsDB";

	public void setDBConnection() throws SQLException {
		if (con == null) {
			con = DriverManager.getConnection(dbUrl + schemaName, username, password);
		}
	}

	public int insert(Student std) throws SQLException {

	    psm = con.prepareStatement(insertQuery);
		psm.setInt(1, 0);
		psm.setString(2, std.getName());
		psm.setString(3, std.getEmail());
		psm.setString(4, std.getMob());

		int count = psm.executeUpdate();
		return count;

	}

	public Student selectByEmail(String email) throws SQLException {

		psm = con.prepareStatement(selectByEmailQuery);
		psm.setString(1, email);

		ResultSet rs = psm.executeQuery();// exectute Select query and copy the result to ResultSet
		rs.next();// move the cursor to first record/row

		String name = rs.getString("name");
		String sEmail = rs.getString("email");
		String mob = rs.getString("mob");

		Student std = new Student(name, sEmail, mob);
		return std;
	}

	public void updateEmail(String curEmail, String newEmail) throws SQLException {

	    psm = con.prepareStatement(updateQuery);
		psm.setString(1, newEmail);
		psm.setString(2, curEmail);

		int count = psm.executeUpdate();

		if (count == 0) {
			SQLException sqlex = new SQLException("email id do not exist");
			throw sqlex;
		}
	}

	public int deleteByEmail(String email) {
		int count = 0;

		return count;
	}

	public void disconnect() throws SQLException {
		con.close();
	}

	/*public Student[] selectAll() throws SQLException
	{
	    psm = con.prepareStatement(countRecords);
	    ResultSet rs = psm.executeQuery();
		rs.next();// move the cursor to first record/row
		int count = rs.getInt(1);
						
		Student[] students = new Student[count];//students array
        
		psm = con.prepareStatement(selectQuery);
		
		ResultSet studentsResultSet = psm.executeQuery();
		
		for (int i = 0; i <= students.length-1; i++)
		{
			studentsResultSet.next();// move the cursor to next record/row
			String name = studentsResultSet.getString("name");
			String email =studentsResultSet.getString("email");
			String mob = studentsResultSet.getString("mob");
			Student sdt = new Student(name,email,mob);
			students[i] = sdt;
		}

		return students;
	}*/
	
	public List<Student> selectAll() throws SQLException
	{
        List<Student> studentList = new ArrayList<Student>();//students List
        
		psm = con.prepareStatement(selectQuery);
		
		ResultSet studentsResultSet = psm.executeQuery();
		
		while(studentsResultSet.next())
		{
			String name = studentsResultSet.getString("name");
			String email =studentsResultSet.getString("email");
			String mob = studentsResultSet.getString("mob");
			Student sdt = new Student(name,email,mob);
			
			studentList.add(sdt);//insert
		}

		return studentList;
	}
}
/*
 *next() Moves the cursor forward one row from its current position.
 * A ResultSet cursor is initially positioned before the first row; 
 * the first call to the method next makes the first row the current row;
 *  the second call makes the second row the current row, and so on.
 * When a call to the next method returns false,if the cursor is positioned after the last row
*/
 


