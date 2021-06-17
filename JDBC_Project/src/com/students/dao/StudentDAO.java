package com.students.dao;

import java.sql.SQLException;

import com.students.entity.Student;

public interface StudentDAO
{
   public void createStudent(Student std) throws SQLException;
   public void getStudentById(Integer id);
   public void updateStudentEmail(Integer id,String newEmail);
   public void deleteStudent(Integer id);
   public void getAllStudents();
}
