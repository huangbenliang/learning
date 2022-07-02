package jishi;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HJ17 {
	static int x = 0, y = 0;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] split = br.readLine().split(";");

		String[] split = "A10;S20;W10;D30;X;A1A;B10A11;;A10;".split(";");
		for (String s : split) {
			if (!valid(s)) continue;
			work(s);
		}
		System.out.println(x + "," + y);
	}

	private static void work(String str) {
		int num = Integer.parseInt(str.substring(1));
		switch (str.charAt(0)) {
			case 'A': {
				x -= num;
				break;
			}
			case 'D':
				x += num;
				break;
			case 'W':
				y += num;
				break;
			case 'S':
				y -= num;
				break;
		}
	}

	private static boolean valid(String str) {
		if (str.length() <2) return false;
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				if (str.charAt(i) - 'A' < 0 || str.charAt(i) - 'Z' > 0) return false;
				continue;
			}
			if (str.charAt(i) - '0' < 0 || str.charAt(i) - '9' > 0) return false;
		}
		return true;
	}

	@Test
	public void test(){
		String[] split = "A10;S20;W10;D30;X;A1A;B10A11;;A10;".split(";");
		for (String str : split) {
			if (!str.matches("[WASD][0-9]{1,2}")) continue;
			work(str);
		}
		System.out.println(x + "," + y);
	}
}
