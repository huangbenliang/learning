package com.atguigu.java;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
	//反射之前,对Person的操作
	@Test
	public void test1() {
		Person p1 = new Person("Tom", 12);
		p1.age = 10;
		System.out.println(p1);
		p1.show();
	}

	//反射之后,对于person的操作
	@Test
	public void test2() throws Exception {
		//通过反射,创建对象
		Class clazz = Person.class;
		Constructor constructor = clazz.getConstructor(String.class, int.class);
		Object tom = constructor.newInstance("Tom", 12);
		Person p = (Person) tom;
		System.out.println("p = " + p);
		//调用对象制定的属性或方法
		//调用属性
		Field age = clazz.getDeclaredField("age");
		age.set(p, 10);
		System.out.println("p = " + p);
		//调用方法
		Method show = clazz.getDeclaredMethod("show");
		Object invoke = show.invoke(p);
	}
}
