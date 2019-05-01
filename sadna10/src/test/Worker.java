package test;

import java.io.Serializable;

public class Worker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private int age;

	public Worker(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public Worker() {
		name = "";
		id = 0;
		age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " " + id + " " + age + " ";
	}
}