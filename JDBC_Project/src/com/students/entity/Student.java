package com.students.entity;


//Entity
public class Student{
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
	
	

}







