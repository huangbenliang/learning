package huisu;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
	Queue<String> queue;
	int step;

	public int openLock(String[] deadends, String target) {
		queue = new LinkedList<>();
		Set<String> dead = new HashSet<>();
		for (int i = 0; i < deadends.length; i++) {
			dead.add(deadends[i]);
		}

		Set<String> isVisited = new HashSet<>();
		queue.offer("0000");
		isVisited.add("0000");

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (dead.contains(cur)) continue;
				if (cur.equals(target)) return step;
				for (int j = 0; j < 4; j++) {
					String plus = plusOne(cur, j);
					if (!isVisited.contains(plus)) {
						queue.add(plus);
						isVisited.add(plus);
					}
					String minus = minusOne(cur, j);
					if (!isVisited.contains(minus)) {
						queue.add(minus);
						isVisited.add(minus);
					}
				}
			}
			step++;
		}
		return -1;
	}

	private String plusOne(String cur, int j) {
		char[] chars = cur.toCharArray();
		if (chars[j] == '9') {
			chars[j] = '0';
		} else {
			chars[j]++;
		}
		return new String(chars);
	}

	private String minusOne(String cur, int j) {
		char[] chars = cur.toCharArray();
		if (chars[j] == '0') {
			chars[j] = '9';
		} else {
			chars[j]--;
		}
		return new String(chars);
	}

	@Test
	public void test() {
		int res = openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}
				, "8888");
		System.out.println("res = " + res);
	}
}