package miji._01array._05huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

public class P3 {
	public static void main(String[] args) {
		System.out.println(new P3().lengthOfLongestSubstring("abcdbef"));
	}
	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> window=new HashMap<>();
		int left=0,right=0;
		int res=0;
		char[] chs = s.toCharArray();
		while (right < chs.length) {
			char chRight=chs[right++];
			window.put(chRight, window.getOrDefault(chRight, 0)+1);
			while (window.get(chRight) > 1) {
				char chLeft=chs[left];
				left++;
				window.put(chLeft, window.get(chLeft)-1);
			}
			res=Math.max(res, right-left);
		}
		return res;
	}
}
