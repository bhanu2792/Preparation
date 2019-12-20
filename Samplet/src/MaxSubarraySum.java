import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaxSubarraySum {

	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				ar[i] = Integer.parseInt(inp[i]);
			}
			maxSubArraySum(ar, len, bw);
		}
		br.close();
		bw.close();
	}

	public static void maxSubArraySum(int[] arr, int len, BufferedWriter bw) throws IOException {

		int max_so_far = Integer.MIN_VALUE;
		int start = 0, end = 0;
		int max_end_here = 0;
		int s = 0;

		for (int i = 0; i < len; i++) {

			max_end_here = max_end_here + arr[i];

			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
				start = s;
				end = i;
			}

			if (max_end_here < 0) {
				max_end_here = 0;
				s = i + 1;
			}
		}

		bw.write(max_so_far+" ");
		bw.write(start+" ");
		bw.write(end+"\n");
		
	}
}
