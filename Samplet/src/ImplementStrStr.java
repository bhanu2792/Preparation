
public class ImplementStrStr {

	public static void main(String[] arg0) {
		int i = strStr("babbaaabaaaabbababaaabaabbbbabaaaabbabbabaaaababbabbbaaabbbaaabbbaabaabaaaaababbaaaaaabababbbbba", "bababbbbbbabbbaabbaaabbbaababa");
		System.out.println(i);
	}

	public static int strStr(String A, String B) {

		 if(B.isEmpty() || A.isEmpty())
	            return -1;
	        if(B == null || A == null)
	            return -1;
	        
	        int j=0;
	        int i=0;
	        int len = A.length();
	        int patLen = B.length();
	        for ( i =0; i<len && j < patLen; i++) {
	            if (A.charAt(i) == B.charAt(j)) {
	                j++;
	            }
	            else {
	                    j = 0;
	                    i = i-j;
	            }
	        }
	        if (j == patLen) {
                return i-j;
            }
	        return -1;
	}
}
