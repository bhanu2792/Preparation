import java.util.HashMap;

public class FindingFreq {

	public static void main(String[] args) {
		int[] arr = { -6, 10, -1, 20, -1, 15, 5, -1, 15 };
		findFreq(arr, -1);
	}

	public static void findFreq(int[] arr, int k) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hs.containsKey(arr[i])) {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			} else {
				hs.put(arr[i], 1);
			}
		}
		int count = 0;
		if (hs.containsKey(k)) {
			count = hs.get(k);
		}
		System.out.println(count);
	}
}
