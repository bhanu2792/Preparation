import java.util.Scanner;

public class ProductOfTwoMat {

	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scan = new Scanner(System.in);
	        int inputCount = scan.nextInt();
	        for (int i =0; i<inputCount; i++){
	            int row1 = scan.nextInt();
	            int col1 = scan.nextInt();
	            int[][] matrix1 = new int[row1][col1];
	            enterMatrixData(scan, matrix1, row1, col1);
	            int row2 = scan.nextInt();
	            int col2 = scan.nextInt();
	            int[][] matrix2 = new int[row2][col2];
	            enterMatrixData(scan, matrix2, row2, col2);
	            productMat(matrix1,matrix2,row1,row2,col2);
	        }
	    }
	    
	    public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol) {
	        for (int i = 0; i < matrixRow; i++) {
	            for (int j = 0; j < matrixCol; j++) {
	                matrix[i][j] = scan.nextInt();
	            }
	        }
	    }
	    public static void productMat(int[][] mat1, int[][] mat2, int row1, int row2, int col2) {
	        for (int i = 0; i < row1; i++) {
	            for (int j = 0; j < col2; j++) {
	                int sum = 0;
	                for (int k = 0; k < row2; k++) {
	                    sum += mat1[i][k] * mat2[k][j];
	                }
	                System.out.print(sum + "");
	            }
	            System.out.println();
	        }

	    }

}
