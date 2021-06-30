package com.jspiders.students.utils;

import java.util.Comparator;

import com.students.entity.Student;

public class StudentMobComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2)
	{
		String mob1 = s1.getMob();
		String mob2 = s2.getMob();
		
		int res = mob1.compareTo(mob2);
		return res;
	}

}
