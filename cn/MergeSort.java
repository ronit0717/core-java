public class Solution {
	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		sort(arr, 0, n-1);
	}

	private static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int p1 = low;
		int p2 = mid + 1;
		int i = 0;
		while (p1 <= mid && p2 <= high) {
			if (arr[p1] <= arr[p2]) {
				temp[i] = arr[p1];
				p1++;
			} else {
				temp[i] = arr[p2];
				p2++;
			}
			i++;
		}
		while (p1 <= mid) {
			temp[i] = arr[p1];
			p1++;
			i++;
		}
		while (p2 <= high) {
			temp[i] = arr[p2];
			p2++;
			i++;
		}
		int j = low;
		for (int k = 0; k < temp.length; k++) {
			arr[j] = temp[k];
			j++;
		}
	}
}