
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 0;
		try {
			 T = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			return;
		}

		for (int t = 0; t < T; t++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len];
			String[] inp = br.readLine().split(" ");
			for (int m = 0; m < len; m++) {
				arr[m] = Integer.parseInt(inp[m]);
			}
			int ans = isPossible(arr, len);

			if (ans < 0) {
				bw.write("Impossible");
				bw.write(System.lineSeparator());
			} else {
				bw.write(ans + "\n");
			}
		}
		bw.flush();
	}

	public static int isPossible(int[] arr, int len) {

		double sum = 0;
		for (int k = 0; k < len; k++) {
			sum = sum + arr[k];
		}
		double med = sum / len;

		for (int j = 0; j < len; j++) {
			double num = (sum - arr[j]) / (len - 1);
			if (num == med) {
				return j+1;
			}
		}

		return -1;
	}
}
