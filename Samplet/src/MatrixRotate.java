
public class MatrixRotate {

	public static void matrixRotate(int mat[][], int len) {

		int temp = 0;
		for (int i = 0; i < len / 2; i++) {

			for (int j = i; j < len - i - 1; j++) {
				temp = mat[i][j];
				mat[i][j] = mat[j][len - i - 1];
				mat[j][len - i - 1] = mat[len - i - 1][len - j - 1];
				mat[len - i - 1][len - j - 1] = mat[len - j - 1][i];
				mat[len - j - 1][i] = temp;
			}
		}
	}

	static void printMatrix(int mat[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] arg0) {
		int mat[][] = { { 1, 2, 3  }, 
				        { 5, 6, 7  },
                        { 9, 10, 11 }, 
                        };

		matrixRotate(mat, 3);
		printMatrix(mat, 3);
	}
}
