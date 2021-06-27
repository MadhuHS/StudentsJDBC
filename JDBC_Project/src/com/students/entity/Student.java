package com.students.entity;

//Entity
public class Student {
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
	public int hashCode()
	{
		int mob = Integer.parseInt(getMob());
		return mob;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Student s1 = (Student) obj;
		String s1Email = s1.getEmail();	
		String s2Email = this.getEmail();
		
		String s1Mob = s1.getMob();
		String s2Mob = this.getMob();
		
		System.out.println(s1Email+" == "+s2Email);
		System.out.println(s1Mob+" == "+s2Mob);
		
		if(s1Email.equalsIgnoreCase(s2Email) || s1Mob.equalsIgnoreCase(s2Mob))
		{
			return true;//if they are same
		}
		
		return false;//if they are diff
	}

}







