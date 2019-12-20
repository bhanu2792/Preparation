import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sample {

	static final int i = 26;
	 static String timeConversion(String s) {
	        /*
	         * Write your code here.
	         */
	        int hour = Integer.parseInt(s.substring(0,2));
	        int minute = Integer.parseInt(s.substring(3,5));
	        int second = Integer.parseInt(s.substring(6,8));
	        String meridiem = s.substring(8,10);
	        int hours = ((hour != 12) && meridiem.equals("PM"))? hour+12 : 00;

	        String hr = Integer.toString(hours);
	 String min = Integer.toString(minute);
	  String sec = Integer.toString(second);

	String finalVal = String.format("%02d",hr) + ":" + String.format("%02d",min) +":" + String.format("%02d",sec);
	if (meridiem == "PM"){
	    return finalVal+"PM";
	}else {
	    return finalVal+"AM";
	}

}
	 
	 public String isEven(int num) {
		 if (num%2 == 0) {
			 return "YES";
		 }
		 return "NO";
	 }

	   // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

       List<Integer> ls = new ArrayList<Integer>();
       ls.add(0);

       for (int i = 0; i < a.size() ; i++){
           if (a.get(i) > b.get(i))
               ls.add(0, ls.get(i)+1);
            else 
               ls.add(1, ls.get(i)+1);
       }
      return ls;
    }
	
	static  class TrieNode {

		TrieNode[] child = new TrieNode[26];

		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int j = 0; j < 26; j++) {
				child[j] = null;
			}
		}
	}
	
	static TrieNode root;
	
	public static void insert (String st) {
		
		int index;
		TrieNode tr = root;
		int level;
		int len = st.length();
		for (level = 0; level < len ; level++) {
		     index = st.charAt(level) - 'a';
			if (tr.child[index] == null) {
				tr.child[index] = new TrieNode();
			}
		     tr = tr.child[index];
		}
		tr.isEndOfWord = true;
	}
	
	static  boolean search (String st) {
		
		int index;
		int level;
		TrieNode tr = root;
		int len = st.length();
		for (level = 0; level< len; level++) {
			 index = st.charAt(level) - 'a';
			 if (tr.child[index] == null) {
				 break;
			 }
			 tr = tr.child[index];
		}
		
		if (level == len) {
			return true;
		}
		
		return false;
		
		
	}
	
	static public void matrixRotate(int[][] mat, int n) {
		int[][] m = new int[n][n];
		int k = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j =0; j<n; j++) {
                 m[j][i] = mat[k][j];				
			}
			k++;
		}
		
		for(int l = 0 ; l<n; l++) {
			for (int v = 0; v<n; v++) {
				System.out.print(m[l][v]);
			}
			System.out.println();
		}
	}
	
	
	 // Driver 
    public static void main(String args[]) 
    { 
        // Input keys (use only 'a' through 'z' and lower case) 
		/*
		 * String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		 * 
		 * String output[] = {"Not present in trie", "Present in trie"};
		 * 
		 * 
		 * root = new TrieNode();
		 * 
		 * // Construct trie int i; for (i = 0; i < keys.length ; i++) insert(keys[i]);
		 * 
		 * // Search for different keys if(search("ther") == true)
		 * System.out.println("the --- " + output[1]); else
		 * System.out.println("the --- " + output[0]);
		 * 
		 * if(search("these") == true) System.out.println("these --- " + output[1]);
		 * else System.out.println("these --- " + output[0]);
		 * 
		 * if(search("their") == true) System.out.println("their --- " + output[1]);
		 * else System.out.println("their --- " + output[0]);
		 * 
		 * if(search("thaw") == true) System.out.println("thaw --- " + output[1]); else
		 * System.out.println("thaw --- " + output[0]);
		 */
         
    	
    	int mat[][] = 
            { 
                {1, 2, 3, 4}, 
                {5, 6, 7, 8}, 
                {9, 10, 11, 12}, 
                {13, 14, 15, 16} 
            }; 
    	
    	matrixRotate(mat,4);
    } 

}
