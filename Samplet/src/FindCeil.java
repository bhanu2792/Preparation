import java.util.Arrays;
import java.util.Scanner;

public class FindCeil {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		int k = scan.nextInt();
		for (int i = 0; i < k; i++) {
			int no = scan.nextInt();
			findCeil(arr, no, size);
		}

	}

	public static void findCeil(int[] arr, int num, int n) {
		Arrays.sort(arr);
		int low = 0;
		int high = n - 1;
		int mid = 0;
		long ans = Integer.MAX_VALUE;
		while (low <= high) {
			mid = (low + high) / 2;
			if (num > arr[mid]) {
				low = mid + 1;
			} else {
				ans = arr[mid];
				high = mid - 1;
			}
		}
		System.out.println(ans);
	}
}