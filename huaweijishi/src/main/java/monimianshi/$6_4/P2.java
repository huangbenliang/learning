package monimianshi.$6_4;

import org.junit.jupiter.api.Test;

public class P2 {
	public int numPairsDivisibleBy60(int[] time) {
		int res = 0;
		for (int i = 0; i < time.length - 1; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if ((time[i] + time[j]) % 60 == 0) res++;
			}
		}
		return res;
	}


	@Test
	public void test() {
		int res = numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
		System.out.println("res = " + res);
	}
}
