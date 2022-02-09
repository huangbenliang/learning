package ch07_advancedSort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {3, 23, 6, 90, 4, 56, 10, 15, 2, 11};
		QuickSortDemo.quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class QuickSortDemo {
	static int[] arr;

	public static int[] quickSort(int[] arrays) {
		arr = arrays;
		quickSort(0, arrays.length-1);
		return arr;
	}

	private static void quickSort(int left, int right) {
		if (left - right >= 0) {
			return;
		}
		int partition = partition(left, right, arr[right]);
		quickSort(left,partition-1);
		quickSort(partition+1,right);
	}

	private static int partition(int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (arr[++leftPtr] < pivot) {
				//non operation
			}
			while (rightPtr > 0 && arr[--rightPtr] > pivot) {
				// 此时右指针指向比pivot大的数
			}
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	private static void swap(int leftPtr, int rightPtr) {
		int temp = arr[leftPtr];
		arr[leftPtr] = arr[rightPtr];
		arr[rightPtr] = temp;
	}
}
