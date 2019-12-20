import java.util.HashSet;

public class ColorFulNo {

	public static void main(String[] agr0) {
		int ans = isColorful(1);
		System.out.println(ans);
	}
	
	public static int isColorful(int A) {
		String number = String.valueOf(A);
		int len = number.length();
		int sum = 1;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i=0; i < len; i++) {
			sum = 1;
			for (int j= i; j < len; j++) {
				 sum = sum * (number.charAt(j)-'0');
				 if (hs.contains(sum)) {
					 return 0;
				 } else {
					 hs.add(sum);
				 }
			}
		}
		return 1;
	}
}
