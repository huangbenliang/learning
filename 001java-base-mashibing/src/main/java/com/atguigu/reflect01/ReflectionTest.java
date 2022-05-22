package com.atguigu.reflect01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionTest {
	@Test
	public void testField() throws Exception {
		Class<Person> personClass = Person.class;
		//创建对象
		Person person = personClass.newInstance();
		//获取制定的属性
		Field id = personClass.getField("id");
		//设置当前属性的值
		id.set(person,1001);

		//获取对象的属性值
		Object pid = id.get(person);
		System.out.println(pid);


	}
}
