import java.io.*;
import java.util.*;

public class SumOfTwo {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i =0; i<input; i++){
            int size = sc.nextInt();
            int[] ar = new int[size];
            for (int j=0; j< size; j++){
                ar[j] = sc.nextInt();
            }
            boolean b = sumOfTwoNo(ar, size);
            if (b) {
               System.out.println("Yes");
            } else {
               System.out.println("No");
            }
        }
    }
    
    public static boolean sumOfTwoNo(int[] arr, int n){
        HashSet<Integer> hs = new HashSet<Integer>();
        int sum =0;
        int k = (int) (Math.pow(80, 2)-1);
        int rem =0;
        for (int i=0; i < n; i++){
            hs.add(arr[i]);
            sum = sum + arr[i];
        }
        if (sum %2 != 0) {
            return false;
        }
        sum = sum/2;
        for (int j=0; j < n; j++){
             rem = sum - arr[j];
             if (hs.contains(rem)){
                 return true;
             }
        }
        return false;
    }
}