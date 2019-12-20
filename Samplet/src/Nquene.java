
public class Nquene {

	public static void main(String[] arg0) {

		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0, 4) == false) {
			System.out.print("Solution does not exist");

		} else {
			printSolution(board, 4);
		}

	}

	public static void printSolution(int board[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	public static boolean isSafe(int board[][], int row, int col, int N) {
		int i, j;
		for (i = row; i >= 0; i--) {

			if (board[i][col] == 1)
				return false;
		}

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (i = row, j = col; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
       return true;
	}

	public static boolean solveNQUtil(int board[][], int row, int N) {

		if (row == N) {
			return true;
		}

		for (int i = 0; i < N; i++) {

			if (isSafe(board, row, i, N) == true) {
				board[row][i] = 1;

				if (solveNQUtil(board, row + 1, N)) {
					return true;
				}

				board[row][i] = 0;

			}

		}
		return false;
	}
}
