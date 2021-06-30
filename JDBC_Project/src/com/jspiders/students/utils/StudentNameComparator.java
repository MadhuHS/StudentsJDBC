package com.jspiders.students.utils;

import java.util.Comparator;

import com.students.entity.Student;

public class StudentNameComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2)
	{
		String name1 = s1.getName();
		String name2 = s2.getName();
		
		int res = name1.compareTo(name2);
		return res;
	}

}
