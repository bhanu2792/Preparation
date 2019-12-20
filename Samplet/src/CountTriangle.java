import java.util.Arrays;
import java.util.Scanner;

public class CountTriangle {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt(); for(int
		 * i=0; i<input; i++){ int size = scan.nextInt(); int[] arr = new int[size]; for
		 * (int j=0; j<size; j++){ arr[j] = scan.nextInt(); }
		 * 
		 * }
		 */ 
        
        int arr[] = {4, 2, 10, 12, 8, 10};
        countTriangle(arr,6);
    }
	
	public static void countTriangle(int[] arr, int n){
        Arrays.sort(arr);
        int count =0;
        for (int i=0; i < n-2; i++){
            for (int j=i+1; j<n-1; j++){
            	int k=j+1;
                while (k < n && arr[i]+arr[j] > arr[k]){
                    k++;
                    count++;
                }
            }
        }
        System.out.println(count);       
    }
}
