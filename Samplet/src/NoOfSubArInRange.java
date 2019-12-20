import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class NoOfSubArInRange {

	static int countSubArr(int arr[], int n, int x) {
		int sum = 0;
		int start = 0;
		int end = 0;
		int count = 0;

		while (end < n) {
			sum = sum + arr[end];
			while (start <= end && sum > x) {
				sum = sum - arr[start];
				start++;
			}
			count = count + (end - start + 1);
			end++;
		}
		return count;
	}

	static int findSum(int arr[], int n, int L, int R) {

		int rightCount = countSubArr(arr, n, R);
		int leftCount = countSubArr(arr, n, L);

		return rightCount - leftCount;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n, a, b;
			String[] inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			a = Integer.parseInt(inp[1]);
			b = Integer.parseInt(inp[2]);
			inp = br.readLine().split(" ");
			int ar[] = new int[n];
			for (int j = 0; j < n; j++)
				ar[j] = Integer.parseInt(inp[j]);

			int ans = findSum(ar, n, a, b);

			bw.write(ans + "\n");
		}
		bw.flush();
	}
}

