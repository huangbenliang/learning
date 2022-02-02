package miji._01array._02chafen;

import java.util.Arrays;

public class P370 {
	public static void main(String[] args) {
		P370 p370 = new P370();
		int[][] arrays = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
		int[] modifiedArray = p370.getModifiedArray(5, arrays);
		System.out.println(Arrays.toString(modifiedArray));
	}

	int[] getModifiedArray(int length, int[][] updates) {
		Diff diff = new Diff(new int[length]);
		for (int i = 0; i < updates.length; i++) {
			diff.operate(updates[i][0], updates[i][1], updates[i][2]);
		}
		return diff.getRes();
	}

	class Diff {
		private int[] arr;

		public Diff(int n) {
			this(new int[n]);
		}

		public Diff() {
		}

		public Diff(int[] nums) {
			arr = new int[nums.length];
			arr[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				arr[i] = nums[i] - nums[i - 1];
			}
		}

		void operate(int i, int j, int val) {
			arr[i] += val;
			if (j + 1 < arr.length) {
				arr[j + 1] -= val;
			}
		}

		int[] getRes() {
			int[] res = new int[arr.length];
			res[0] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				res[i] = res[i - 1] + arr[i];
			}
			return res;
		}
	}

}


