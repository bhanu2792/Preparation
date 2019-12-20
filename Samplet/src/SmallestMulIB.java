import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestMulIB {

	public int mod(String s, int N) {
		int rem = Integer.parseInt(s)%N;
		return rem;
	}

	public String multiple(int A) {
		Queue<String> q = new LinkedList<String>();
		Set<Integer> s = new HashSet<Integer>();
		String t = "1";
		q.add(t);

		while (!q.isEmpty()) {
			t = q.poll();

			int rem = Integer.parseInt(t) % A;

			if (rem == 0) {
				return t;
			}

			if (!s.contains(rem)) {
				q.add(t + "0");
				q.add(t + "1");
				s.add(rem);
			}
		}

		return "";
	}

}
