import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoOfIceLand {

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
			int ans = countIceLand(mat, ROW, COL);
			bw.write(ans + "\n");
		}
		br.close();
		bw.close();
	}

	public static int countIceLand(int[][] mat, int row, int col) {
		boolean[][] isVisit = new boolean[row][col];
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1 && isVisit[i][j] == false) {
					DFS(mat, i, j, isVisit);
					count++;
				}
			}
		}
		return count;
	}

	public static void DFS(int[][] mat, int row, int col, boolean[][] isVisit) {
		int[] rowNo = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNo = { -1, 0, 1, -1, 1, -1, 0, 1 };
		isVisit[row][col] = true;

		for (int m = 0; m < 8; m++) {
			if (isValid(mat, isVisit, row + rowNo[m], col + colNo[m])) {
				DFS(mat, row + rowNo[m], col + colNo[m], isVisit);
			}
		}
	}

	public static boolean isValid(int[][] mat, boolean[][] isVisit, int row, int col) {

		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (mat[row][col] == 1 && !isVisit[row][col]);

	}
}
