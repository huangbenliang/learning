package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
	@Test
	public void test1() throws Exception {
		Properties p = new Properties();

		//FileInputStream is = new FileInputStream("/jdbc.properties");


		InputStream in = ClassLoaderTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		p.load(in);
		String user = p.getProperty("user");
		System.out.println("user = " + user);
	}
}
