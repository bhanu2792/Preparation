import java.io.*;
import java.util.*;

public class Solution11 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt();
		 * scan.next(); for (int i = 0; i < input; i++) { int len = scan.nextInt();
		 * String st = scan.nextLine(); boolean b = stringPalindrome(st); if (b) {
		 * System.out.println("Yes"); } else { System.out.println("No"); } }
		 */

		boolean b = isSplitEven(1);
		if (b) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
	
	public static boolean isSplitEven(long num){
        if (num%2==0){
            return true;
        }
        return false;
    }

	public static boolean stringPalindrome(String s) {
		int j = s.length() - 1;
		int i = 0;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}