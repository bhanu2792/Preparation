package SalesForce;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b));

		sc.close();
	}

	public static long countMax(List<String> upRight) {
    // Write your code here
        int len = upRight.size();
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            String[] ar = upRight.get(i).split(" ");
            a[i] = Integer.valueOf(ar[0]);
            b[i] = Integer.valueOf(ar[1]);
        }
        return solve(a, b);
    }

    static long solve(int[] a, int[] b) {
        return (long) Arrays.stream(a).min().getAsInt() * Arrays.stream(b).min().getAsInt();
    }
}