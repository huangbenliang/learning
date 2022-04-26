package com.atguigu.java;


import org.junit.jupiter.api.Test;

public class ReflectionTest {
	//反射之前,对Person的操作
	@Test
	public void test1(){
		Person p1 = new Person("Tom",12);
		p1.age=10;
		System.out.println(p1);
		p1.show();
	}
}
