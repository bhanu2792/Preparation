import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class WindowMax {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 4 10 54 11 8 7 9
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt(); for (int i
		 * = 0; i < input; i++) { int size = scan.nextInt(); int k = scan.nextInt();
		 * int[] arr = new int[size]; for (int j = 0; j < size; j++) { arr[j] =
		 * scan.nextInt(); } int ans = findMaxInWindow(arr, k); System.out.println(ans);
		 * }
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());
		for (int i = 0; i < input; i++) {
			int n, k;
			String[] inp = br.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			k = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(inp[j]);
			}
			int ans = findMaxInWindow(arr, k);
			bw.write(ans + "\n");
		}
		bw.flush();
	}

	public static int findMaxInWindow(int[] arr, int k) {
		int len = arr.length;
		int ans = 0;
		Deque<Integer> de = new LinkedList<Integer>();
		int i = 0;
		for (; i < k; i++) {
			while (!de.isEmpty() && arr[de.peekLast()] <= arr[i]) {
				de.removeLast();
			}
			de.addLast(i);
		}

		for (; i < len; i++) {

			ans = ans + arr[de.peek()];

			while (!de.isEmpty() && de.peek() <= i - k) {
				de.removeFirst();
			}

			while (!de.isEmpty() && arr[de.peekLast()] <= arr[i]) {
				de.removeLast();
			}
			de.addLast(i);

		}

		ans = ans + arr[de.peek()];

		return ans;
	}

}
