
public class KMPAlgorithm {

	public static void main(String[] arg0) {
		String txt = "AAAAABBAACAAB";
		String pat = "AAB";
		KmpAlgo(txt, pat);
	}

	public static void KmpAlgo(String txt, String pat) {
		int txtLen = txt.length();
		int patLen = pat.length();
		int i = 0;
		int j = 0;
		int[] arr = ComputeArray(pat, patLen);
		while (i < txtLen) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}

			if (j == patLen) {
				System.out.println("Pattern fount at index " + (i - j));
				j = arr[j - 1];
			} else if (i < txtLen && txt.charAt(i) != pat.charAt(j)) {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	public static int[] ComputeArray(String st, int len) {
		int[] ar = new int[len];
		ar[0] = 0;
		int i = 1;
		int j = 0;

		while (i < len) {

			if (st.charAt(i) == st.charAt(j)) {
				j++;
				ar[i] = j;
				i++;
			} else {

				if (j != 0) {
					j = j - 1;
				} else {
					ar[i] = j;
					i++;
				}
			}

		}

		return ar;
	}

}
