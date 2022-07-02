package jishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HJ27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int num = Integer.parseInt(split[0]);
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 1; i < num + 1; i++) {
			strings.add(split[i]);
		}
		String target = split[num + 1];
		char[] chars1 = target.toCharArray();
		Arrays.sort(chars1);
		String s1 = new String(chars1);
		int k = Integer.parseInt(split[num + 2]);
		List<String> collect = strings.stream().filter(s -> !s.equals(target) && s.length() == target.length()).filter(str -> {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String s = new String(chars);
			if (s.equals(s1)) {
				return true;
			} else {
				return false;
			}
		}).sorted().collect(Collectors.toList());
		System.out.println(collect.size());
		if (k < collect.size()) {
			System.out.println(collect.get(k-1));
		}

	}
}
