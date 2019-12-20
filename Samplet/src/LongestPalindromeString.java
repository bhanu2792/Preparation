
public class LongestPalindromeString {

	public static void main(String[] arg0) {
		LongPalindromSubStr("mzmqnnrkurfmmfrukrnnqsm");
	}

	public static void LongPalindromSubStr(String A) {

		int low = 0;
		int high = 1;
		int maxlen = 1;
		int len = A.length();
		int start =0;
		for (int i = 1; i < len; i++) {
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && A.charAt(low) == A.charAt(high)) {

				if (high - low + 1 > maxlen) {
					maxlen = high - low + 1;
					start = low;
				}
				--low;
				++high;
			}

			low = i - 1;
			high = i + 1;

			while (low >= 0 && high < len && A.charAt(low) == A.charAt(high)) {

				if (high - low + 1 > maxlen) {
					maxlen = high - low + 1;
					start = low;
				}
				--low;
				++high;
			}
		}
		System.out.println(maxlen);
		System.out.println(A.substring(start, start+maxlen));
	}
}
