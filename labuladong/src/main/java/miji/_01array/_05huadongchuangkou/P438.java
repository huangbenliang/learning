package miji._01array._05huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P438 {
	public static void main(String[] args) {
		System.out.println(new P438().findAnagrams("cbaebabacd", "abc"));
	}
	public List<Integer> findAnagrams(String s, String p) {
		HashMap<Character,Integer> need=new HashMap();
		HashMap<Character,Integer> window=new HashMap();
		for (char c : p.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0)+1);
		}
		int left=0;
		int right=0;
		int valid=0;
		List<Integer> res=new ArrayList<>();
		char[] chs = s.toCharArray();
		while (right < chs.length) {
			char ch = chs[right++];
			if (need.containsKey(ch)) {
				window.put(ch,window.getOrDefault(ch,0)+1);
				if (window.get(ch).equals(need.get(ch))) {
					valid++;
				}
			}
			//System.out.printf("扩大[%d,%d]\n",left,right);

			//收缩窗口
			if (right - left == p.length()) {
				if (valid == need.size()) {
					res.add(left);
				}
				char chLeft=chs[left++];
				//System.out.printf("收缩[%d,%d]",left,right);
				if (need.containsKey(chLeft)) {
					if (window.get(chLeft).equals(need.get(chLeft))) {
						valid--;
					}
					window.put(chLeft, window.get(chLeft)-1);
				}

			}
			//System.out.println();

		}
		return res;
	}
}
