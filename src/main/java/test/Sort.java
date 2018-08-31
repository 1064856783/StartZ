package test;

import java.util.Arrays;

public class Sort {
//	ѡ������
	public static void selectSort(int[] arr) { // ÿ���ڲ�ѭ���Ƚ϶��������� �ڴ濪����
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
//	ѡ�������Ż�
	public static void selectSortBest(int[] arr) { // �������ݵĽ��� ��ʡ�ڴ�
		int minIndex = 0;
		int temp = 0;
		if ((arr == null) || (arr.length == 0))
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;// ����������С���������±�
			for (int j = i + 1; j < arr.length; j++) {
				// �����������ҵ���С���ݲ������������±�
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// �����������������Сֵλ�ò���Ĭ�ϵĵ�һ�����ݣ��򽻻�֮��
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
//	ð������
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
//	�۰����
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
//	��������
	public static void insertionsort(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			// ֻ�ܴӵ�ǰ������ǰѭ������Ϊ����ǰ�������Ϊ����ģ�����ֻҪȷ����ǰ���������ݵ�Ϊֹ����
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}

	}
	
	 public static void doInsertSort(int[] a){
	        for(int index = 1; index<a.length; index++){//������ҵ�index������Ϊ�Ƚ϶�������ݵ�index
	            int temp = a[index];//�����Ƚϵ�����
	            int leftindex = index-1;
	            while(leftindex>=0 && a[leftindex]>temp){//���ȵ�����߻���������tempС������ʱ������ѭ��
	                a[leftindex+1] = a[leftindex];
	                leftindex--;
	            }
	            a[leftindex+1] = temp;//��temp�ŵ���λ��
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
