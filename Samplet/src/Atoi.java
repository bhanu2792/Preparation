
public class Atoi {

	public static void main(String[] arg0) {
       int i = aToI("+123");
       System.out.println(i);
	}

	public static int aToI(String str) {
		int sign = 1;
		int i = 0;
		int base = 0;
		String st = str.trim();
		if (st.charAt(0) == '-') {
			sign = -1;
			i++;
		} 
		
		if (st.charAt(0) == '+') {
			i++;
		}

		while (i < st.length() && st.charAt(i) >= '0' && st.charAt(i) <= '9') {

			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && st.charAt(i) > '7')) {
				if (sign == -1) {
					return Integer.MIN_VALUE;

				} else {
					return Integer.MAX_VALUE;
				}

			}

			base = base * 10 + st.charAt(i)-'0';
			i++;
		}

		return base * sign;
	}

}
