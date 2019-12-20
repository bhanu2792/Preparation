
public class MergeSort {

	public static int count =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 1, 7, 3, 8, 4 };
		MergeSort m = new MergeSort();
		m.mergeSortUtil(arr, 0, 6);
		for (int i = 0; i < 7; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void mergeSortUtil(int[] arr, int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSortUtil(arr, low, mid);
		mergeSortUtil(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public void merge(int[] arr, int low, int mid, int high) {
		int n = high - low + 1;
		int[] temp = new int[n];
		int p1 = low, p2 = mid + 1, k = 0;
		while (p1 <= mid && p2 <= high) {
			if (arr[p1] < arr[p2]) {
				temp[k++] = arr[p1++];
			} else {
				temp[k++] = arr[p2++];
			}
		}

		while (p1 <= mid) {
			temp[k++] = arr[p1++];
		}

		while (p2 <= high) {
			temp[k++] = arr[p2++];
		}

		for (int i = 0; i < k; i++) {
			arr[low + i] = temp[i];
		}
	}
}
