package miji._01array._05huadongchuangkou;

import java.util.HashMap;

public class P567 {
	public static void main(String[] args) {
		System.out.println(new P567().checkInclusion("ab", "eidboaooo"));
	}

	public boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> need = new HashMap<>();
		HashMap<Character, Integer> window = new HashMap<>();
		//所有必需
		for (char c1 : s1.toCharArray()) {
			need.put(c1, need.getOrDefault(c1, 0) + 1);
		}
		int left = 0, right = 0;  //定义指针
		int valid = 0; //满足条件数
		char[] s2c = s2.toCharArray();
		while (right < s2c.length) {
			char c = s2c[right];
			//右窗口右移
			right++;
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);//先放进去再判断,不然无法判断
				if (window.get(c).equals(need.get(c))) {
					valid++;
				}
			}
			System.out.printf("大窗口[%d,%d]", left, right);

			//判断是否左移
			//这里使用while 和if是一样的,因为只相差一个就会移动,
			//和P57不一样,这里不需要移动到包含所有子串的地方再进行移动,当大于子长度时就可以进行移动.
			if (right - left == s1.length()) {
				if (valid == need.size()) {
					return true;
				}
				char cl = s2c[left];
				left++;
				System.out.printf("小窗口[%d,%d]", left, right);
				if (need.containsKey(cl)) {
					if (window.get(cl).equals(need.get(cl))) {  //这个if必须写在前面
						valid--;
					}
					window.put(cl, window.get(cl) - 1); //这里和上面的if不能调换位置,需要先检测是否存在,再相减
				}
			}
			System.out.println();
		}
		return false;
	}
}
