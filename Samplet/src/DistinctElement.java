import java.util.HashMap;

public class DistinctElement {

	public static void main(String[] arg0) {

		int[] a = { -5, -1, 4, 8, -5, -3, -4, 7, 4, -4, 0, 8, 0, -2, 3, 2, 5 };
		distinctEle(a, 13);
	}

	public static void distinctEle(int[] arr, int k) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

		for (int i = 0; i < k; i++) {
			if (hs.containsKey(arr[i])) {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			} else {
				hs.put(arr[i], 1);
			}
		}

		System.out.print(hs.size() + " ");

		for (int i = k; i < arr.length; i++) {
			if (hs.get(arr[i - k]) > 1) {
				hs.put(arr[i - k], hs.get(arr[i - k]) - 1);
			} else {
				hs.remove(arr[i - k]);
			}

			if (hs.containsKey(arr[i])) {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			} else {
				hs.put(arr[i], 1);
			}

			System.out.print(hs.size() + " ");
		}
		System.out.println();
	}
}
