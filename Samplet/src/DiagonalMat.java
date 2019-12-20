
public class DiagonalMat {
	public static void main(String[] args) {
		int mat[][] = { { 1,2,3,4,5}, 
			           { 6,7,8,9,10}, 
			        { 11,12,13,14,15},
			        { 16,17,18,19,20},
			        { 21,22,23,24,25},
			       };
		diagonalSum(mat,5);
	}
	
	public static void diagonalSum (int [][] mat, int n) {
		
		for (int i = n-1; i>=0; i--) {
			int count = 0;
			int sum =0;
			for(int j = i; j<= n-1; j++) {
				sum = sum + mat[count][j];
				count++;
			}
			System.out.print(sum+ " ");
		}
		
		for (int k = 1; k <= n-1; k++ ) {
			int sum1 =0;
			int count = k;
			for (int l=0; l < n-k; l++) {
				sum1 = sum1 + mat[count][l];
				count++;
			}
			System.out.print(sum1+ " ");
		}
	}

}
