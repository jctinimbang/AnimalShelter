package com.pointwest.java.data;

public abstract class Animal {
	private String name;
	private String gender;
	private int age;
	private static int count;
	private int id;

	public abstract String getSignatureSound();

	public abstract String getType();

	public abstract String getfeedResponse();

	public Animal() {
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getcount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
