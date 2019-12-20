import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		int matrixCount = scan.nextInt();
		for (int i = 0; i < matrixCount; i++) {
			System.out.println("Enter The Number Of Matrix Rows");

			int matrixRow = scan.nextInt();

			System.out.println("Enter The Number Of Matrix Columns");

			int matrixCol = scan.nextInt();

			// defining 2D array to hold matrix data
			int[][] matrix = new int[matrixRow][matrixCol];
			// Enter Matrix Data
			enterMatrixData(scan, matrix, matrixRow, matrixCol);
			Spiral(matrix, matrixRow);
		}
	}

	public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol) {
		System.out.println("Your Matrix is : ");

		for (int i = 0; i < matrixRow; i++) {
			for (int j = 0; j < matrixCol; j++) {
				System.out.print(matrix[i][j] + "\t");
			}

			System.out.println();
		}
	}

	public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol) {
		System.out.println("Enter Matrix Data");

		for (int i = 0; i < matrixRow; i++) {
			for (int j = 0; j < matrixCol; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
	}

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
}