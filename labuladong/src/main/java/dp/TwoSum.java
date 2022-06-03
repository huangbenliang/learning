package dp;

import java.util.Arrays;

public class TwoSum {
	int[] twoSum(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] == target) {
				return new int[]{arr[left], arr[right]};
			} else if (arr[left] + arr[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[]{-1, -1};
	}
}
