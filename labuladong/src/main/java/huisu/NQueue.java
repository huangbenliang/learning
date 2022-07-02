package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueue {
	static List<int[][]> res;

	public static void main(String[] args) {
		List<int[][]> res = solve(8);
		System.out.println("res = " + res.size());
	}

	private static List<int[][]> solve(int n) {
		res = new ArrayList<>();
		int[][] arr = new int[n][n];
		int[] nums={3,5,2,6,1,3};
		Arrays.stream(nums).sorted();
		solve(arr, 0);
		return res;
	}

	private static void solve(int[][] arr, int row) {
		if (row == arr.length) {
			res.add(copy(arr));
			return;
		}
		for (int i = 0; i < arr[row].length; i++) {
			if (!isValid(arr, row, i)) continue;
			arr[row][i] = 1;
			solve(arr, row + 1);
			arr[row][i] = 0;
		}
	}

	private static boolean isValid(int[][] arr, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (arr[i][col] == 1) {
				return false;
			}
		}
		for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
			if (arr[row - i][col - i] == 1) return false;
		}
		for (int i = 1; row - i >=0 && col + i<=arr[row-i].length-1; i++) {
			if (arr[row - i][col + i] == 1) return false;
		}
		return true;
	}

	private static int[][] copy(int[][] arr) {
		int[][] res = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		return res;
	}

}

