package miji._01array._05huadongchuangkou;

import java.util.HashMap;

public class P76 {
	public static void main(String[] args) {
		System.out.println(new P76().minWindow("ADOBECODEBANC", "ABC"));
	}
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;
		char[] ss = s.toCharArray();
		while (right < ss.length) {
			char sc = ss[right];
			right++;
			if (need.containsKey(sc)) {
				window.put(sc, window.getOrDefault(sc, 0) + 1);
				if (window.get(sc).equals(need.get(sc))) {
					valid++;
				}
			}
			System.out.printf("窗口1[%d,%d]\n", left,right);

			//判断左侧窗口是否收缩
			while (valid == need.size()) {
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				char d = ss[left];
				left++;
				System.out.printf("窗口2[%d,%d]", left,right);
				if (need.containsKey(d)) {
					if (window.get(d).equals(need.get(d))) {
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
	}
}
