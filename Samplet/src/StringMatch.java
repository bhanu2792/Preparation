import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringMatch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {

			String[] s = br.readLine().split("\\s+");

			String s1 = s[0];
			String s2 = s[1];
			boolean b = isSubSequence(s1, s2);
			if (b) {
				out.write("Yes" + "\n");
			} else {
				out.write("No" + "\n");
			}
		}
		br.close();
		out.close();
	}

	public static boolean isSubSequence(String A, String B) {
		int len1 = A.length();
		int len2 = B.length();

		if (len1 > len2) {
			return false;
		}

		int i = 0, j = 0;

		while (i < len1 && j < len2) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
			}
			j++;
		}

		if (i == len1) {
			return true;
		}

		return false;
	}

}
