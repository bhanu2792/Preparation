import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LargestContiSeqZero {
	public static void main(String[] agr0) {
		Integer[] arr = { 0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0 };

		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
		ArrayList<Integer> ll = new ArrayList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(-3);
		ll.add(3);
		larConSeqZero(arrayList);
	}

	public static ArrayList<Integer> larConSeqZero(ArrayList<Integer> A) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, -1);
		ArrayList<Integer> ls = new ArrayList<Integer>();
		int sum = 0;
		int end = -1;
		int start = -1;
		int len = A.size();
		int maxLen = Integer.MIN_VALUE;

		for (int i = 0; i < len; i++) {
			sum = sum + A.get(i);
			if (sum == 0) {
				if (maxLen < i + 1) {
					maxLen = i - start + 1;
					start = 0;
					end = i;
				}
			}

			if (hm.containsKey(sum)) {
				if (maxLen < (i - hm.get(sum) + 1)) {
					start = hm.get(sum) + 1;
					end = i;
					maxLen = i - hm.get(sum) + 1;
				}
			} else {
				hm.put(sum, i);
			}
		}
		if (start >= 0 && end >= 0) {
			for (int i = start; i <= end; i++) {
				System.out.println(A.get(i));
				ls.add(A.get(i));
			}
		}
		return ls;
	}
}
