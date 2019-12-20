import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		int dividend = -2147483648;
		int divisor = -10000000;
		
		
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(-1);
	    list.add(-2);
	    
	    firstMissingPositive(list);
		//System.out.println(divide(dividend, divisor));

		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		/*
		 * Scanner scan = new Scanner(System.in); int inputSize = scan.nextInt(); for
		 * (int i = 0; i < inputSize; i++) { int a = scan.nextInt(); int[] arr = new
		 * int[a]; for (int j = 0; j < a; j++) { arr[j] = scan.nextInt(); } int k =
		 * scan.nextInt(); boolean b = sumOfPairs(arr, k, a);
		 * 
		 * if (b){ System.out.println("True"); }else System.out.println("False");
		 * 
		 * } scan.close();
		 */

		/*
		 * Scanner scan = new Scanner(System.in); int inputSize = scan.nextInt(); for
		 * (int i =0; i < inputSize; i++){ int a = scan.nextInt(); int[] arr = new
		 * int[a]; int k = scan.nextInt(); for (int j =0; j<a; j++ ){ arr[j] =
		 * scan.nextInt(); }
		 * 
		 * sumOfPairs(arr,k,a); }
		 */
		// scan.close();
		/*
		 * int[] arr = { 10, 10}; int k = 20; int a = 2; sumOfPairs(arr, k, a);
		 */
	}

	    public static int firstMissingPositive(ArrayList<Integer> A) {
	        int[] arr = new int[A.size()];
	        int i =0;
	        for (Integer j: A){
	            arr[i++]= j;
	        }
	        int k = 0,l=arr.length-1;
	        int count =0;
	        while (k<l){
	            if (arr[k]<0){
	                int temp = arr[k];
	                arr[k]= arr[l];
	                arr[l]=temp;
	                l--;
	                count++;
	            }
	            k++;
	        }
	        System.out.println( "count-> " + count);
	        int newSize = arr.length-count;
	        System.out.println( "newSize-> " + newSize);
	        for (int m=0; m<arr.length;m++){
	            
	            if (Math.abs(arr[m]) <= newSize){
	                arr[Math.abs(arr[m])-1] = -arr[Math.abs(arr[m])-1];
	            }
	            
	        }
	        
	         for (int m=0; m<newSize;m++){
	             if (arr[m] > 0){
	                 return m+1;
	             }
	         }
	         
	         return newSize+1;
	    }     
	        
}
