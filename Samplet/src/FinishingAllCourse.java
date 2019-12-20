import java.util.ArrayList;
import java.util.Stack;

public class FinishingAllCourse {

	ArrayList<ArrayList<Integer>> al;

	public FinishingAllCourse(int v) {

		al = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= v; i++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			al.add(ar);
		}

	}

	public void add(FinishingAllCourse f, int a, int b) {
		f.al.get(a).add(b);
	}

	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		FinishingAllCourse m = new FinishingAllCourse(A);
		for (int i = 0; i < B.size(); i++) {
			m.add(m, B.get(i), C.get(i));
		}
		boolean[] st = new boolean[A + 1];
		boolean[] visit = new boolean[A + 1];

		for (int i = 1; i <= A; i++) {
			if (visit[i] == false) {
				if (isCycle(m, st, visit, i)) {
					return 1;
				}
			}
		}

		return 0;
	}

	public boolean isCycle(FinishingAllCourse m, boolean[] st, boolean[] visit, int src) {

		if (visit[src]) {
			return false;
		}

		if (st[src]) {
			return true;
		}

		visit[src] = true;
		st[src] = true;

		for (Integer i : m.al.get(src)) {
			if (isCycle(m, st, visit, src)) {
				return true;
			}
		}

		st[src] = false;

		return false;
	}
}
