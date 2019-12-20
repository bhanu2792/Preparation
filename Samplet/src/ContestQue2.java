import java.util.HashMap;
import java.util.Scanner;

public class ContestQue2 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int inputSize = scan.nextInt();
		for (int i = 0; i < inputSize; i++) {
			int a = scan.nextInt();
			int[] arr = new int[a];
			for (int j = 0; j < a; j++) {
				arr[j] = scan.nextInt();
			}
			int ans = maxLen(arr, a);
			System.out.println(ans);
		}
	}

	public static int maxLen(int arr[], int n) {
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0;
		int max_len = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0)
				max_len = i + 1;

			Integer prev_i = hM.get(sum);

			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else
				hM.put(sum, i);
		}

		return max_len;
	}

}
