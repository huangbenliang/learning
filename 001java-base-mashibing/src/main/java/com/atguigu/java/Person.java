package com.atguigu.java;

import lombok.Data;

@Data
public class Person {
	private String name;
	public int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private Person(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("你好,我是一个人.");
	}

	private String showNation(String nation) {
		System.out.println("我得国籍是:" + nation);
		return nation;
	}
}
