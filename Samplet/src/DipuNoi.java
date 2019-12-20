
public class DipuNoi {
	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 0, 1 }, { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		System.out.println(getMaxIceLand(matrix));
	}

	public static int getMaxIceLand(int[][] matrix) {
		int maxIceland = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					int count = 0;
					count = getIceLandSize(i, j, matrix, count);
					System.out.println(i + " " + j + " " + count);
					if (count > maxIceland) {
						maxIceland = count;
						printMatrix(matrix);
					}
					count = 0;
				}

			}

		}
		return maxIceland;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int getIceLandSize(int i, int j, int[][] matrix, int count) {
		int R = matrix.length;
		int C = matrix[0].length;
		matrix[i][j] = -1;
		count++;
		if (isValid(i, j + 1, R, C, matrix)) {
			getIceLandSize(i, j + 1, matrix, count++);
		}
		if (isValid(i, j - 1, R, C, matrix)) {
			getIceLandSize(i, j - 1, matrix, count++);
		}
		if (isValid(i + 1, j, R, C, matrix)) {
			getIceLandSize(i + 1, j, matrix, count++);
		}
		if (isValid(i - 1, j, R, C, matrix)) {
			getIceLandSize(i - 1, j, matrix, count++);
		}
		return count;
	}

	private static boolean isValid(int i, int j, int R, int C, int[][] matrix) {
		if ((i < 0 || i >= R || j >= C || j < 0) || matrix[i][j] != 1)
			return false;
		return true;
	}

}