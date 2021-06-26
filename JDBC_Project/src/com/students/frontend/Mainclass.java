package com.students.frontend;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.students.dao.StudentDaoImpl;
import com.students.entity.Student;

public class Mainclass 
{
	static final Scanner scn = new Scanner(System.in);
	static final StudentDaoImpl sdi = new StudentDaoImpl();

	public static void addStudent() {
		// add student
		System.out.println("enter name");
		String name = scn.next();

		System.out.println("enter email");
		String email = scn.next();

		System.out.println("enter mobile no");
		String mob = scn.next();

		Student std = new Student(name, email, mob);

		try {
			sdi.createStudent(std);
		} catch (SQLException e) {
			System.out.println();
			System.out.println("OOPS!!! Error while adding " + std.getName());
			System.out.println();

		}
	}

	public static void viewStudent() {
		System.out.println("Please enter registed email-ID");
		String email = scn.next();
		try {
			Student std = sdi.getStudentByEmai(email);

			System.out.println(std.toString());
		} catch (SQLException e) {
			System.out.println("Oops!! student with email id : " + email + " does not exists");
		}
	}

	public static void menu() {
		System.out.println("1.To open the app");
		System.out.println("2. To exit");

		int choice = scn.nextInt();

		if (choice == 1) {
			try {
				sdi.openApp();
				System.out.println("Application is now open");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			while (true) {

				System.out.println("1. add student");
				System.out.println("2. view student");
				System.out.println("3. view all students");
				System.out.println("4. update student email");
				System.out.println("5. update student mob");
				System.out.println("6. delete student");
				System.out.println("Any other key to exit");

				int optn = scn.nextInt();

				switch (optn) {
				case 1:
					addStudent();
					break;

				case 2:
					viewStudent();
					break;

				case 3:
					showAllStudents();
					break;

				case 4:
					updateEmail();
					break;
				
				case 5:
					updateEmail();
					break;
					
				
				default:
					try {
						sdi.closeApp();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					System.out.println("Thank you see you again");
					System.exit(0);// stop the application
				}

			}
		} else {
			System.out.println("Thank you see you again");
			System.exit(0);// stop the application
		}

	}

	public static void updateEmail() {
		System.out.println("enter your current email id");
		String curEmail = scn.next();

		System.out.println("enter your NEW email id");
		String newEmail = scn.next();

		try {
			sdi.updateStudentEmail(curEmail, newEmail);
			System.out.println("Email id changed successfully!!");
		} catch (SQLException e) {
			System.out.println("Oops!! " + e.getMessage());
		}
	}

	public static void showAllStudents() {
		try 
		{
			List<Student> studentsList = sdi.getAllStudents();

			for (int i = 0; i < studentsList.size()-1; i++)
			{
				System.out.println(studentsList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Main starts...");

		//menu();
		try
		{
		 sdi.openApp();
		 showAllStudents();
		 sdi.closeApp();
		}
		catch (SQLException e)
		{
           e.printStackTrace();
		}


		System.out.println("Main ends...");

	}
}
