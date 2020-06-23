package test;

import java.util.Arrays;

public class Sort {
//	选择排序
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
//	选择排序优化
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
//	冒泡排序
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
//	折半查找
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
//	插入排序
	public static void insertionsort(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			// 只能从当前索引往前循环，因为索引前的数组皆为有序的，索引只要确定当前索引的数据的为止即可
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}

	}
	
	 public static void doInsertSort(int[] a){
	        for(int index = 1; index<a.length; index++){//外层向右的index，即作为比较对象的数据的index
	            int temp = a[index];//用作比较的数据
	            int leftindex = index-1;
	            while(leftindex>=0 && a[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
	                a[leftindex+1] = a[leftindex];
	                leftindex--;
	            }
	            a[leftindex+1] = temp;//把temp放到空位上
	        }
	    }
	
	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 2, 6, 5 };
		// selectSort(arr);
		// selectSortBest(arr);
//		bubbleSort(arr);
//		doInsertSort(arr);
		insertionsort(arr);
		System.out.print(Arrays.toString(arr));
		int index = halfSearch(arr, 3);
		System.out.println("\tindex:" + index);

	}

}
