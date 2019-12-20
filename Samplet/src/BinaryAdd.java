
public class BinaryAdd {

	public static void main(String[] arg0) {
		String b = binaryAdd("1","");
		System.out.println(b);
	}
	
	public static String binaryAdd(String A, String B) {
		int Alen = A.length();
		int Blen = B.length();
		int i = Alen-1;
		int j = Blen-1;
		int sum =0;
		String result = "";
		while (i >= 0 || j >= 0 || sum == 1 ) {
			if (i >= 0) {
				sum = sum + (A.charAt(i)-'0');
			}
			if (j >= 0) {
				sum = sum + (B.charAt(j)-'0');
			}
			result = (char)(sum % 2 + '0') + result;
			sum = sum/2;
			i--;
			j--;
		}
		return result;
	}
}
