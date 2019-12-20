
public class CountAndSay {

	public static void main(String[] arg0) {
	String st =	coundSay(3);
	//System.out.println(st);
	}

	public static String coundSay(int N) {
		String str = "1";
		int count = 1;
		
		for (int i = 0; i < N-1; i++) {
			StringBuffer sb = new StringBuffer();
			int j = 0;
			count = 1;
			int len = str.length();
			while (j < len - 1) {

				if (str.charAt(j) == str.charAt(j+1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(str.charAt(j));
					count = 1;
				}
				j++;

			}
			
			sb.append(count);
			sb.append(str.charAt(str.length() - 1));
			str = sb.toString();
			//System.out.println(str);
		}
		System.out.println(str);
		return str;
	}
}
