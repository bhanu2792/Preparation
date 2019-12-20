import java.util.HashMap;
import java.util.Map;

public class Quadruples {

	public static void main(String[] arg0) {

		int[] a = { 31, 8, 28, 10 };
		int[] b = { 18, 7, 22, 5 };
		int[] c = { 16, 25, 20, 14 };
		int[] d = { 39, 9, 34, 19 };
		//isQuadruples(a, b, c, d);

		int[] e = { 49, 73, 58, 30, 72, 44, 78, 23 };
		int[] f = { 9, 40, 65, 92, 42, 87, 3, 27 };
		int[] g = { 29, 40, 12, 3, 69, 9, 57, 60 };
		int[] h = { 33, 99, 78, 16, 35, 97, 26, 12 };

		// Output is 36
		isQuadruples(e, f, g, h);

	}

	public static void isQuadruples(int[] a, int[] b, int[] c, int[] d) {
		HashMap<Integer, Integer> hs1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hs2 = new HashMap<Integer, Integer>();

		int count = 0;
		int x = 0;
		int len = a.length;
		int val1 = 0, val2 = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				val1 = a[i] ^ b[j];
				val2 = x ^ c[i] ^ d[j];
				if (hs1.containsKey(val1)) {
					hs1.put(val1, hs1.get(val1) + 1);
				} else {
					hs1.put(val1, 1);
				}
				if (hs2.containsKey(val2)) {
					hs2.put(val2, hs2.get(val2) + 1);
				} else {
					hs2.put(val2, 1);
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : hs2.entrySet()) {

			if (hs1.containsKey(entry.getKey())) {

				count = count + hs1.get(entry.getKey()) * entry.getValue();

			}
		}

		System.out.println(count);
	}
}
