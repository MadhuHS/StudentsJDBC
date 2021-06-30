package com.jspiders.students.utils;

import java.util.Comparator;

import com.students.entity.Student;

public class StudentEmailComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2)
	{
		String email1 = s1.getEmail();
		String email2 = s2.getEmail();
		
		int res = email1.compareTo(email2);
		return res;
	}

}
