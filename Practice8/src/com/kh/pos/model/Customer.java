package com.kh.pos.model;

public class Customer {
	private String name;
	private int age;
	private int points;
	public Customer() {
		super();
	}
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", points=" + points + "]";
	}

}
