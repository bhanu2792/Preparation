
public class LastWordLen {

	public static void main(String[] arg0) {
		lenLastWord("  ");
	}

	public static void lenLastWord(String A) {
		if (A.trim().length() == 0) {
			System.out.println(0);
			return;
		}
		String[] st = A.split(" ");

		int len = st.length;

		int lastLen = st[len - 1].length();

		System.out.println(lastLen);

	}

}
