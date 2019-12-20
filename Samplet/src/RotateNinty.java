
public class RotateNinty {

	public static void matrixRotate(int mat[][], int len) {
		int size = len-1;
		
		for (int i=0; i<len/2;i++) {
			int count = size;
			for (int j = i; j<len-i-1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[count][i];
				 mat[count][i] = mat[size][count];
				 mat[size][count] = mat[j][size];
				 mat[j][size] = temp;
				 count--;
			}
			size--;
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
		int mat[][] = { { 1, 2, 3}, 
				        { 5, 6, 7},
                        { 9, 10, 11},
                        
                        
                        };

		matrixRotate(mat, 3);
		printMatrix(mat, 3);
	}
}
