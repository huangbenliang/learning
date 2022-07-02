import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MainTest {
	int[] temp;

	@Test
	public void test() {
/*		String[] arr=new String[]{"abcde","ab123","a2222"};
		System.out.println(match(arr, "abcd3"));
		System.out.println(cal(9));*/
		int[] arr = new int[]{5, 2, 3, 7,1,3,14,8,1,19,8};

		//quicksort(arr);
		guiBing(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void guiBing(int[] arr) {
		temp = new int[arr.length];
		//guiBing(arr, 0, arr.length);
		guiBing1(arr, 0, arr.length-1);
	}

	private void guiBing(int[] arr, int lo, int hi) {
		if (lo == hi-1) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		guiBing(arr, lo, mid);
		guiBing(arr, mid, hi);
		merge(arr, lo, mid, hi);

	}private void guiBing1(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		guiBing1(arr, lo, mid);
		guiBing1(arr, mid+1, hi);
		merge1(arr, lo, mid, hi);

	}

	private void merge(int[] arr, int lo, int mid, int hi) {
		for (int i = lo; i < hi; i++) {
			temp[i] = arr[i];
		}
		int i = lo;
		int j = mid;
		for (int p = lo; p < hi; p++) {
			if (i == mid) {
				arr[p] = temp[j++];
			} else if (j == hi) {
				arr[p] = temp[i++];
			} else if (temp[i] > temp[j]) {
				arr[p] = temp[j++];
			} else {
				arr[p] = temp[i++];
			}
		}
	}
	private void merge1(int[] arr, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			temp[i] = arr[i];
		}
		int i = lo;
		int j = mid+1;
		for (int p = lo; p <= hi; p++) {
			if (i == mid+1) {
				arr[p] = temp[j++];
			} else if (j == hi+1) {
				arr[p] = temp[i++];
			} else if (temp[i] > temp[j]) {
				arr[p] = temp[j++];
			} else {
				arr[p] = temp[i++];
			}
		}
	}

	private void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int p = partition(arr, lo, hi);
		quicksort(arr, lo, p - 1);
		quicksort(arr, p + 1, hi);
	}

	private int partition(int[] arr, int lo, int hi) {
		int temp = arr[lo];
		int i = lo;
		int j = hi;
		while (i != j) {
			while (j > i && arr[j] >= temp) {
				j--;
			}
			while (j > i && arr[i] <= temp) {
				i++;
			}
			if (j > i) {
				swap(arr, i, j);
			}
		}
		if (i != lo) {
			swap(arr, i, lo);
		}
		return i;
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public String match(String[] arr, String target) {
		int max = 0;
		String res = "";
		char[] chars = target.toCharArray();
		for (String s : arr) {
			char[] temp = s.toCharArray();
			int count = 0;
			int unMatch = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == chars[i]) {
					count++;
				} else {
					unMatch++;
				}
				System.out.println("i = " + i);
				if (unMatch >= target.length() - max) {
					break;
				}
			}

			if (count > max) {
				res = s;
				max = count;
			}
			if (max == target.length()) {
				return res;
			}
		}
		return res;
	}

	public int cal(int n) {
		if (n == 1) return 1;
		if (n % 2 == 0) {
			return -(n / 2);
		} else {
			return n - n / 2;
		}
	}


}
