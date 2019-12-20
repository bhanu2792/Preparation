import java.util.HashMap;

public class LongestSub {

	public static void main(String[] arg0) {
		int i = larSubWithoutRepeat("GEEKSFORGEEKS");
		System.out.println(i);
	}
	
	public static int larSubWithoutRepeat(String A) {
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		String s = A.trim();
		int len = s.length();
		int start = 0;
		int i =0;
		if (len == 1) {
			return 1;
		}
		if (len == 0) {
			return 0;
		}
		int maxLen = 1;
		int curLen = 0;
		hs.put(s.charAt(0), 0);
		for (i = 1; i < len; i++) {
			if (hs.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) >= start) {
				curLen = i - start;
				if (curLen > maxLen) {
					maxLen = curLen;
				}
				start = hs.get(s.charAt(i)) + 1;
			}
			hs.put(s.charAt(i), i);
		}

		curLen = len - start;
		if (curLen > maxLen) {
			maxLen = curLen;
		}
		return maxLen;
	}
}
