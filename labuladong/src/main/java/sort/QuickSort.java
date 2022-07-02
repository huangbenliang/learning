package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class QuickSort {
	static int[] arr = new int[]{3, 5, 7, 9, 4, 28, 2, 10, 6, 9, 28};

	public static void main(String[] args) {
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
		HashMap<Object, Object> map = new HashMap<>();
		map.put(null, 1);
		Hashtable hashtable = new Hashtable();
		hashtable.put(null, 1);
	}

	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int p = partition(arr, lo, hi);

		quickSort(arr, lo, p - 1);
		quickSort(arr, p + 1, hi);
	}

	private static int partition(int[] arr, int lo, int hi) {
		int tem = arr[lo];
		int i = lo;
		int j = hi;
		while (i != j) {
			while (j > i && arr[j] >= tem) {
				j--;
			}
			while (j > i && arr[i] <= tem) {
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

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
