package com.students.entity;


//Entity
public class Student implements Comparable<Student> {
	private Integer id;
	private String name;
	private String email;
	private String mob;

	public Student() {
		super();
	}

	public Student(String name, String email, String mob) {
		super();
		this.name = name;
		this.email = email;
		this.mob = mob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "name : " + name + " email : " + email + " mob : " + mob;
	}
	
	
	@Override
	public int compareTo(Student std)
	{
		String s1Name = std.getName();
		String s2Name = this.getName();
		
		String s1Mob = std.getMob();
		String s2Mob = this.getMob();
		
		String s1Email = std.getEmail();
		String s2Email = this.getEmail();
		
		int res;
		
		if(s1Email.equalsIgnoreCase(s2Email) || s1Mob.equalsIgnoreCase(s2Mob))
		{
			return 0;//reject
		}
		
		if(s1Name.equalsIgnoreCase(s2Name) == true)
		{
			res = s1Mob.compareTo(s2Mob);
		}
		else
		{
			res = s1Name.compareTo(s2Name);
		}
		
		return res;
	}

}







