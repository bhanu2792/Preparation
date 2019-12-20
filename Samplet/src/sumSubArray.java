import java.util.Scanner;

public class sumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		long[] preArr = preComputeArr(arr);
		int a = scan.nextInt();
		for (int j = 0; j < a; j++) {
			int b = scan.nextInt();
			int c = scan.nextInt();
			sumOfSubarray(preArr, b, c);
		}

	}

	public static void sumOfSubarray(long[] arr, int a, int b) {
		if (arr.length == 1) {
			System.out.println(arr[0]);
			return;
		}
		long result = arr[b] - arr[a - 1];
		System.out.println(result);
	}

	public static long[] preComputeArr(int[] arr) {
		int len = arr.length;
		long sum = 0;
		long[] ar = new long[len];
		for (int i = 0; i < len; i++) {
			sum = sum + arr[i];
			ar[i] = sum;
		}

		return ar;
	}

}
