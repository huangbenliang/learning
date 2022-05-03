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

		//调用私有构造器
		Constructor con = clazz.getDeclaredConstructor(String.class);
		con.setAccessible(true);
		Person jerry = (Person)con.newInstance("jerry");
		System.out.println("jerry = " + jerry);

		//调用私有属性
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(jerry, "碎冰冰");
		System.out.println("jerry = " + jerry);

		Method showNation = clazz.getDeclaredMethod("showNation", String.class);
		showNation.setAccessible(true);
		String nation =(String) showNation.invoke(jerry, "中国");
		System.out.println("nation = " + nation);



	}
}
