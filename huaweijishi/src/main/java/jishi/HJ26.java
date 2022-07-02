package jishi;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.LinkedList;

public class HJ26 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
		String str = "A Famous Saying: Much Ado About Nothing (2012/8).";
		LinkedList<Character> container = new LinkedList<>();
		char little = 'a', big = 'A';
		int count=0;
		while (count<26) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == little || c == big) {
					container.addLast(c);
				}
			}
			little++;
			big++;
			count++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (c - 'a' >= 0 && c - 'z' <= 0 || c - 'A' >= 0 && c - 'Z' <= 0) {
				sb.append(container.removeFirst());
			} else {
				sb.append(c);
			}
		}
		System.out.println(sb);
		Assertions.assertEquals("A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8). ", sb.toString());
	}
}
