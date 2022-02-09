package miji._01array._06erFenSouSuo;

public class P875 {
	public static void main(String[] args) {
		System.out.println(new P875().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
	}

	public int minEatingSpeed(int[] piles, int h) {
		int left = 1, right = 1_000_000_001;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (f(piles, mid) == h) {
				right = mid;
			} else if (f(piles, mid) < h) {
				right = mid;
			} else if (f(piles, mid) > h) {
				left = mid + 1;
			}
		}
		return left;
	}

	private int f(int[] piles, int x) {
		int hours = 0;
		for (int n : piles) {
			hours += n / x;
			if (n % x != 0) {
				hours++;
			}
		}
		return hours;
	}
}
