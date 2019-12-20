
public class SpiralMatrix {

	public static void Spiral(int mat[][], int len) {

		int R = 0;
		int C = len;
		int j = 0;
		int k = 0;
		int m = 0;
		int n = 0;
		int i = 0;

		while (R < C) {

			for (j = R; j < C; j++) {
				System.out.print(mat[i][j] + " ");
			}
			i++;

			for (k = i; k < C; k++) {
				System.out.print(mat[k][C - 1] + " ");

			}
			k--;
			for (m = k - 1; m >= R; m--) {
				System.out.print(mat[C - 1][m] + " ");
			}

			for (n = k - 1; n > R; n--) {
				System.out.print(mat[n][R] + " ");
			}

			R++;
			C--;
		}
	}

	public static void main(String[] arg0) {
		int mat[][] = { { 1, 2, 3, 4 }, 
				      { 5, 6, 7, 8 }, 
				      { 9, 10, 11, 12 }, 
				      { 13, 14, 15, 16 }, };

		Spiral(mat, 4);
	}
}
