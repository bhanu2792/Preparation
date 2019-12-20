import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < input; i++) {
			String s = sc.nextLine();
			String[] sub = s.split(" ");
			boolean b = isAnagram(sub);
			if (b == true) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}

	public static boolean isAnagram(String[] str) {

		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		char[] s1 = str[0].toCharArray();
		char[] s2 = str[1].toCharArray();
		int i = 0;

		if (s1.length != s2.length) {
			return false;
		}
		while (i < s1.length && i < s2.length) {
			arr1[s1[i] - 'a']++;
			arr2[s2[i] - 'a']++;
			i++;
		}
		int j = 0;
		while (j < 26) {
			if (arr1[j] != arr2[j]) {
				return false;
			}
			j++;
		}
		return true;
	}
}