import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContestQue1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());

		for (int i = 0; i < input; i++) {
			String[] sub = br.readLine().split("\\s+");
			boolean b = isSubPalindrome(sub[0], sub[1]);
			if (b == true) {
				bw.write("Yes" + "\n");
			} else {
				bw.write("No" + "\n");
			}
		}
		br.close();
		bw.close();
	}

	public static boolean isSubPalindrome(String a, String b) {
		int a1[] = new int[26];
		int a2[] = new int[26];

		if (a.equals(b)) {
			return true;
		} else {
			for (int i = 0; i < Math.max(a.length(), b.length()); i++) {

				if (i < a.length())
					a1[a.charAt(i) - 97]++;
				if (i < b.length())
					a2[b.charAt(i) - 97]++;
			}

			int flag2 = 0;
			for (int i = 0; i < 26; i++) {
				if (a1[i] > 0 && a2[i] > 0) {
					flag2 = 1;
					break;
				}

			}
			if (flag2 == 1)
				return true;

			return false;
		}
	}
}
