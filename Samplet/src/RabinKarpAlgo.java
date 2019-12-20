
public class RabinKarpAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txt = "interviewseiwcombvinterviewskrenlzp";
		String pat = "interviews";
		isMatch(txt, pat);
	}

	public static void isMatch(String txt, String pat) {
		int patLen = pat.length();
		int txtLen = txt.length();
		int patHash = 0, txtHash = 0;
		int charSize = 256;
		int p = 101;
		int h = 1;
		for (int i = 0; i < patLen - 1; i++) {
			h = (h * charSize) % p;
		}

		for (int i = 0; i < patLen; i++) {
			patHash = (charSize * patHash + pat.charAt(i)) % p;
			txtHash = (charSize * txtHash + txt.charAt(i)) % p;
		}

		for (int i = 0; i <= txtLen - patLen; i++) {
			if (patHash == txtHash) {

				int j = 0;
				int k = i;
				while (j < patLen && k < txtLen) {
					if (txt.charAt(k) != pat.charAt(j)) {
						break;
					}
					k++;
					j++;
				}
				if (j == patLen)
					System.out.println("Matched at " + i);

			}
			if (i < txtLen - patLen) {

				txtHash = (charSize * (txtHash - txt.charAt(i) * h) + txt.charAt(i + patLen)) % p;

				if (txtHash < 0)
					txtHash = (txtHash + p);

			}
		}

	}
}
