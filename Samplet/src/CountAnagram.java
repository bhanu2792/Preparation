import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountAnagram {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			String s1 = s[0];
			String s2 = s[1];
			countNo(s1, s2);
		}
		br.close();
		out.close();
	}

	public static void countNo(String A, String B) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		char[] s1 = A.toCharArray();
		char[] s2 = B.toCharArray();
		int i = 0;
		int j = 0;
		int len1 = A.length();
		int len2 = B.length();
		while (i < s1.length) {
			arr1[s1[i] - 'a']++;
			i++;
		}

		while (j < s2.length) {
			arr2[s2[j] - 'a']++;
			j++;
		}

		int k = 0;

		int count = 0;
		while (k < 26) {
			count = count + 2 * (Math.min(arr1[k], arr2[k]));
			k++;
		}
		int ans = (len1 + len2) - count;
		System.out.println(ans);
	}

}
