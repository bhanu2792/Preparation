
public class ValidNo {

	public static void main(String[] arg0) {
		int b = isValidNo("0.1");
		System.out.println(b);
	}

	public static int isValidNo(String A) {
		//String A = A.trim();
		int len = A.length();
		int letter = 0;
		int e = 0;
		int num = 0;
		int dot = 0;
		int i=0;
		if (len ==0 || A.charAt(len-1) == '.') {
			return 0;
		}
		if(A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == ' ') {
            i++;
	    }
		while (i < len) {
			letter = A.charAt(i);

			if (letter > 47 && letter < 58) {
				num++;
			} else if (letter == ' ' || letter == '-' || letter == '+') {

			} else if (letter == '.' && i < len - 1 && A.charAt(i + 1) > 47 && A.charAt(i + 1) < 58) {
				if (e > 0) {
					return 0;
				} else {
					dot++;
				}
			} else if (letter == 'e') {
				e++;
			} else {
				return 0;
			}
            i++;
		}
		if (num < 1) {
			return 0;
		}
		if (dot > 1 || e > 1) {
			return 0;
		}
		
		return 1;

	}
}
