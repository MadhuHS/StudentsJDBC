package com.students.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.students.entity.Student;

public interface StudentDAO
{
   public void openApp() throws SQLException;
   
   public void createStudent(Student std) throws SQLException;
   public void getStudentById(Integer id);
   public Student getStudentByEmai(String email)throws SQLException;
   public void updateStudentEmail(String curEmail,String newEmail)throws SQLException;
   public void deleteStudent(Integer id);
   public ArrayList<Student> getAllStudents()throws SQLException;
   
   public void closeApp() throws SQLException;

}
