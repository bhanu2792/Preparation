
public class EnclosingSubstring {

	public static void main(String[] arg0) {
		String pat = "bloets";
		String txt = "lwbcrsfothplxseplrtbshbtstjloxsf";
		smallestWindow(txt, pat);
	}

	public static void smallestWindow(String txt, String pat) {
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] patCount = new int[256];
		int[] txtCount = new int[256];
		int count = 0;
		int start = 0;
		int windowLen = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < patLen; i++) {
			patCount[pat.charAt(i)]++;
		}

		for (int j = 0; j < txtLen; j++) {
			txtCount[txt.charAt(j)]++;

			if (patCount[txt.charAt(j)] >= txtCount[txt.charAt(j)]) {
				count++;
			}

			if (count == patLen) {

				while (txtCount[txt.charAt(start)] > patCount[txt.charAt(start)] || patCount[txt.charAt(start)] == 0) {

					if (txtCount[txt.charAt(start)] > patCount[txt.charAt(start)]) {
						txtCount[txt.charAt(start)]--;
					}
					start++;

				}
				windowLen = j - start + 1;
				if (windowLen < minLen) {
					minLen = windowLen;
				}
			}

		}

		if (minLen == Integer.MAX_VALUE) {
			minLen = -1;
		}
		System.out.println(minLen);
	}
}
