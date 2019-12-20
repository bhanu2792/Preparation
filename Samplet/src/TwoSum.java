import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stubS
		Integer[] arr = { 2, 7, 11, 15 };

		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(2);
		ls.add(7);
		ls.add(11);
		ls.add(15);
		twoSum(arrayList, 9);
	}

	public static List<Integer> twoSum(List<Integer> A, int B) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int len = A.size();
		int rem = 0;
		for (int i = 0; i < len; i++) {
			rem = B - A.get(i);
			if (hm.containsKey(rem)) {
				ls.add(hm.get(rem) + 1);
				ls.add(i + 1);
				break;
			} else {
				if (!hm.containsKey(A.get(i)))
				    hm.put(A.get(i), i);
			}
		}
		return ls;
	}
}
