import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramInterviewBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "cat", "dog", "god", "tca" };
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
		anagrams(arrayList);
	}

	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		HashMap<String, ArrayList<Integer>> hs = new HashMap<String, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = A.size();
		for (int i = 0; i < len; i++) {
			char[] arr = A.get(i).toCharArray();
			Arrays.sort(arr);
			String str = String.valueOf(arr);
			ArrayList<Integer> ar;
			if (!hs.containsKey(str)) {
				ar = new ArrayList<Integer>();
			} else {
				ar = hs.get(str);
			}
			ar.add(i+1);
            hs.put(str, ar);
		}
		
		for(Map.Entry<String, ArrayList<Integer>> entry : hs.entrySet()) {
            res.add(entry.getValue());
        }
		return res;
	}
}
