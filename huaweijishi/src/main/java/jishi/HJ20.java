package jishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ20 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			judge(s);
		}
	}

	private static void judge(String str) {
		if (str.length() < 9) {
			System.out.println("NG");
			return;
		}
		int isDigital = 0;
		int isBigWord = 0;
		int isSmallWord = 0;
		int isSymbol = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isDigital + isBigWord + isSmallWord + isSymbol > 2) break;
			char c = str.charAt(i);
			if (c - 'A' >= 0 && c - 'Z' <= 0) isBigWord = 1;
			else if (c - 'a' >= 0 && c - 'z' <= 0) isSmallWord = 1;
			else if (c - '0' >= 0 && c - '9' <= 0) isDigital = 1;
			else isSymbol = 1;
		}
		if (isDigital + isBigWord + isSmallWord + isSymbol <= 2) {
			System.out.println("NG");
			return;
		}
		if (isDuplicate(str, 3)) {
			System.out.println("NG");
			return;
		}
		System.out.println("OK");
	}

	private static boolean isDuplicate(String str, int length) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length() - length + 1; i++) {
			String subStr = str.substring(i, i + length);
			if (map.get(subStr) == null) {
				map.put(subStr, 1);
			} else {
				return true;
			}
		}
		return false;
	}
}
