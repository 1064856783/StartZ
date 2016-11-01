package test;

import java.util.Arrays;

public class Sort {
	public static void selectSort(int[] arr) { // 每次内层循环比较都交换数据 内存开销大
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	public static void selectSortBest(int[] arr) { // 减少数据的交换 节省内存
		int minIndex = 0;
		int temp = 0;
		if ((arr == null) || (arr.length == 0))
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;// 无序区的最小数据数组下标
			for (int j = i + 1; j < arr.length; j++) {
				// 在无序区中找到最小数据并保存其数组下标
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	private static void bubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int halfSearch(int[] arr, int target) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (max + min) / 2;
		while (true) {
			if (target < arr[mid]) {
				max = mid - 1;
			} else if (target > arr[mid]) {
				min = mid + 1;
			} else {
				return mid;
			}
			if (max < min) {
				return -1;
			}
			mid = (max + min) / 2;

		}

	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 2, 6, 5 };
		// selectSort(arr);
		// selectSortBest(arr);
		bubbleSort(arr);
		System.out.print(Arrays.toString(arr));
		int index = halfSearch(arr, 7);
		System.out.println("\tindex:" + index);

	}

}
