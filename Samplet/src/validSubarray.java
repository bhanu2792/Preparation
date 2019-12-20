import java.util.HashMap;
import java.util.Scanner;

public class validSubarray {

	   public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt(); for(int
		 * i=0; i<input; i++){ int size = scan.nextInt(); int[] arr = new int[size]; for
		 * (int j=0; j<size; j++){ arr[j] = scan.nextInt(); } countValidSubarray(arr); }
		 */
	        int[] a = {1, 1, 1, 1};
	        countValidSubarray(a);
	    }
	    
	    public static void countValidSubarray(int[] arr){
	        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
	        int sum = 0;
	        int count = 0;
	        for (int i=0; i<arr.length; i++){
	            if (arr[i]==0){
	                arr[i] = -1;
	            }
	            
	            sum = sum + arr[i];
	            if (sum == 0){
	                count++;
	            }
	            
	            if (hs.containsKey(sum)){
	                count+=hs.get(sum);
	                hs.put(sum,hs.get(sum)+1);
	            } else {
	                hs.put(sum,1);
	            }
	        }
	        System.out.println(count);
	    }
}
