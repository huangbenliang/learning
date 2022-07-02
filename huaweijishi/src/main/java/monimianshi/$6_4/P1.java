package monimianshi.$6_4;

import org.junit.jupiter.api.Test;

public class P1 {
	public boolean isPowerOfThree(int n) {
		if (n == 0) return false;
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res = i * i * i;
			if (res == n) return true;
			if (res > n) return false;
		}
		return false;
	}

	@Test
	public void test1(){
		boolean powerOfThree = isPowerOfThree(9);
		System.out.println("powerOfThree = " + powerOfThree);
	}
}
