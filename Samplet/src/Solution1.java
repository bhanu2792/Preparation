import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt(); for(int
		 * i=0; i<input; i++){ long num = scan.nextLong(); cubeRoot(num); }
		 */
        
        cubeRoot(-27);
    }
    
    public static void cubeRoot(long num){
        long low =1;
        long high = num;
        long mid = 0;
        long value =0;
        boolean isFound = false;
        long newNum = Math.abs(num);
        while (low < high){
            mid = (low+high)/2;
            value = mid * mid * mid;
            if (value == newNum){
                isFound = true;
                break;
            } else if (value < num){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        
        if (isFound == true){
            if (num < 0)
                System.out.println(-value);
            else 
                System.out.println(value);
        }
        
    }
}