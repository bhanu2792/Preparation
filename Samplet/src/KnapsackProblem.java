import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KnapsackProblem {

	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			String[] inp = br.readLine().split("\\s+");
			int S = Integer.parseInt(inp[0]);
			int len = Integer.parseInt(inp[1]);
			int[] wt = new int[len];
			int[] val = new int[len];
			for (int i = 0; i < len; i++) {
				inp = br.readLine().split("\\s+");
				wt[i] = Integer.parseInt(inp[0]);
				val[i] = Integer.parseInt(inp[1]);
			}
			int ans = knapSack(S, wt, val, len);
			bw.write(ans + "\n");
		}
		br.close();
		bw.close();
	}

	public static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}
}
