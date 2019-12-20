import java.util.HashMap;

public class SmallWindowEle {

	public static void main(String[] arg0) {
	String s= smallestWinLen("ADOBECODEBANC", "ABC");
	System.out.println(s);
	}
	
	public static String smallestWinLen(String A, String B) {
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		int len1 = A.length();
		int len2 = B.length();
		int count = 0;
		int start = 0;
		int maxLen = Integer.MAX_VALUE;
		int startIndex = -1;
		if (len2 > len1) {
			return "";
		}
		for (int j=0; j< len2; j++) {
			if (hm1.containsKey(B.charAt(j))) {
				hm1.put(B.charAt(j),hm1.get(B.charAt(j))+1);
			} else {
				hm1.put(B.charAt(j), 1);
			}
		}
		
        for (int i = 0; i < len1 ; i++) {
        	if (hm2.containsKey(A.charAt(i))) {
				hm2.put(A.charAt(i),hm2.get(A.charAt(i))+1);
			} else {
				hm2.put(A.charAt(i), 1);
			}
        	
        	if (hm1.containsKey(A.charAt(i)) && hm2.get(A.charAt(i)) <= hm1.get(A.charAt(i))) {
        		count++;
        	}
        	
        	if (count == len2) {
        		
				while ((hm1.containsKey(A.charAt(start)) && hm2.get(A.charAt(start)) > hm1.get(A.charAt(start)) ) || !hm1.containsKey(A.charAt(start))) {
        			
        			if (hm1.containsKey(A.charAt(start)) && hm2.get(A.charAt(start)) > hm1.get(A.charAt(start)))
        				hm2.put(A.charAt(start), hm2.get(A.charAt(start))-1);
        			start++;
        		}
        		if (maxLen > i-start+1) {
        			maxLen = i-start+1;
        			startIndex = start;
        		}
        	}

        }		
		
        if (startIndex == -1) {
        	return "";
        }
		
		return A.substring(startIndex, startIndex+maxLen);
	}
	
}

