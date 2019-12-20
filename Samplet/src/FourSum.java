import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {
//1 0 -1 0 -2 2
	public static void main(String[] arg) {
		Integer[] A = { 9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1,
				-6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1,
				-2, 5, -2 };
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(A));
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(0);
		a.add(-1);
		a.add(0);
		a.add(-2);
		a.add(2);
		fourSum(arrayList, 0);
	}

	public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
		int len = A.size();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		Collections.sort(A);
		int k = 0;
		int l = 0;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				k = j + 1;
				l = len - 1;
				while (k < l) {
					sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);
					if (sum == B) {
						ArrayList<Integer> ele = new ArrayList<Integer>();
						ele.add(A.get(i));
						ele.add(A.get(j));
						ele.add(A.get(k));
						ele.add(A.get(l));
						if (!hs.contains(ele)) {
							res.add(ele);
							hs.add(ele);
						}
						k++;
						l--;
					} else if (sum > B) {
						l--;
					} else {
						k++;
					}
				}
			}
		}
		return res;
	}
}
