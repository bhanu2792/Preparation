import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContestQue5 {

	public static int ROW = 0;
	public static int COL = 0;

	public static void main(String[] arg) throws NumberFormatException, IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			ROW = Integer.parseInt(inp[0]);
			COL = Integer.parseInt(inp[1]);
			int[][] mat = new int[ROW][COL];
			String st;
			for (int i = 0; i < ROW; i++) {
				st = br.readLine();
				for (int j = 0; j < COL; j++) {
					mat[i][j] = st.charAt(j) - '0';
				}
			}
			int ans = minimumflip(mat, ROW, COL);
			bw.write(ans + "\n");
		}
		br.close();
		bw.close();
	}

	public static int minimumflip(int arr[][], int N, int M) {

		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				// check if this cell equals 0
				if (arr[i][j] == 0) {
					// increase the number of moves
					ans++;

					// flip from this cell to the start point
					for (int k = 0; k <= i; k++) {
						for (int h = 0; h <= j; h++) {
							// flip the cell
							if (arr[k][h] == 1) {
								arr[k][h] = 0;
							} else {
								arr[k][h] = 1;
							}
						}
					}
				}
			}
		}
		return ans;
	}
}
