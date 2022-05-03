package com.atguigu.reflect01;

@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
	public int id;
	int age;
	private String name;

	public Person() {
	}

	@MyAnnotation
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@MyAnnotation("abc")
	private Person(String name) {
		this.name = name;
	}

	private String show(String nation) {
		System.out.println("nation = " + nation);
		return nation;
	}

	public String display(String interest) {
		return interest;
	}


	@Override
	public void info() {
		System.out.println("我是一个人");
	}

	@Override
	public int compareTo(String o) {
		return 0;
	}
}
