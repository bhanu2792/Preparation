import java.io.*;
import java.util.*;

public class NoOfDivisor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt(); for (int
		 * i=0; i<input; i++){ long num = scan.nextLong(); int ans = numOfDivisors(num);
		 * System.out.println(ans); }
		 */
        
        int ans = numOfDivisors(23);
        System.out.println(ans);
    }
    
    public static int numOfDivisors(long num){
        int count =0;
        int s = (int) Math.sqrt(num);
        for (int i=1; i <= s; i++){
            if (i*i == s){
                return (2*count)-1;
            }
            if (num%i == 0){
                count++;
            }
        }
        return 2*count;
    }
}