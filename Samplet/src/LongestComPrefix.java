import java.util.ArrayList;

public class LongestComPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("ab");
		ar.add("a");
		ar.add("ab");
		ar.add("a");
	String s= longestPrefix(ar);
	System.out.println(s);
	}

	public static String longestPrefix(ArrayList<String> A) {
		int len = A.size();
		if (len == 1) {
			return A.get(0);
		}
		int min = Integer.MAX_VALUE;
		String str = "";
		for (int i = 1; i < len; i++) {
			int k = 0;
			StringBuffer sb = new StringBuffer();
			int len1 = A.get(i).length();
			int len2 = A.get(i - 1).length();
			while (k < len1 && k < len2) {
				if (A.get(i).charAt(k) == A.get(i - 1).charAt(k)) {
					sb.append(A.get(i).charAt(k));
				} else {
					break;
				}
				k++;
			}
			if (sb.length() < min) {
				str = sb.toString();
				min = str.length();
			}
		}

		return str;
	}

}
