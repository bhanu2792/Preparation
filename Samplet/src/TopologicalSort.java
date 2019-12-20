import java.io.IOException;
import java.util.ArrayList;

public class TopologicalSort {

	public static void main(String[] arg0) throws NumberFormatException, IOException {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ArrayList<Integer> aq = new ArrayList<Integer>();
		aq.add(2);
		aq.add(3);
		aq.add(4);

		int as = solve(4, ar, aq);
		System.out.println(as);
	}

	public static int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

		@SuppressWarnings("unchecked")
		ArrayList<Integer> al[] =  new ArrayList[A + 1];
		for (int i = 0; i <= A; i++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			al[i] = ar;
		}

		for (int k = 0; k < B.size(); k++) {
			al[B.get(k)].add(C.get(k));
		}

		boolean[] st = new boolean[A + 1];
		boolean[] visit = new boolean[A + 1];

		for (int j = 1; j <= A; j++) {
			if (isCycle(al, st, visit, j)) {
				return 0;
			}
		}

		return 1;
	}

	public static boolean isCycle(ArrayList<Integer> al[], boolean[] st, boolean[] visit, int src) {

		if (st[src]) {
			return true;
		}

		if (visit[src]) {
			return false;
		}

		visit[src] = true;
		st[src] = true;

		for (Integer i : al[src]) {
			if (isCycle(al, st, visit, i)) {
				return true;
			}
		}

		st[src] = false;

		return false;
	}
}
