package $01exception;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	@Test
	void tryTest() {
		String str = "abc";
		try {
			int integer = Integer.parseInt(str);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			System.out.println("ExceptionTest.tryTest");
		}
		System.out.println("str = " + str);
	}
}
