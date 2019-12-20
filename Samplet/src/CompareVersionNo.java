import java.math.BigInteger;

public class CompareVersionNo {

	public static void main(String[] arg0) {
		int k = compareVersion("444444444444444444444444", "44444444444444444");
		System.out.println(k);
	}

	public static int compareVersion(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int i = 0;
		int j = 0;

		BigInteger base1 = new BigInteger("0");
		BigInteger base2 = new BigInteger("0");
		int m = 10;
		while (i < lenA || j < lenB) {
			while (i < lenA && A.charAt(i) != '.') {
				base1 = base1.multiply(BigInteger.valueOf(m)).add(BigInteger.valueOf(A.charAt(i) - '0'));
				i++;
			}
			while (j < lenB && B.charAt(j) != '.') {
				base2 = base2.multiply(BigInteger.valueOf(m)).add(BigInteger.valueOf(B.charAt(j) - '0'));
				j++;
			}
			int cmp = base1.compareTo(base2);
			if (cmp != 0) {
				return cmp;
			} else {
				base1 = BigInteger.valueOf(0);
				base2 = BigInteger.valueOf(0);
				i++;
				j++;
			}
		}
		return 0;
	}

}
