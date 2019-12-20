import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestDistanceIB {

	public static void main(String[] arg0) {
		LargestDistanceIB an = new LargestDistanceIB();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(-1);
		ar.add(0);

		ar.add(0);
		ar.add(1);
		ar.add(2);
		ar.add(1);
		ar.add(5);

		int a = an.solve(ar);
		System.out.println(a);
	}

	public int solve(ArrayList<Integer> A) {

		Pair4 a1 = largestDis(A, 0);
		Pair4 a2 = largestDis(A, a1.vertex);
		return a2.distance;
	}

	public Pair4 largestDis(ArrayList<Integer> A, int src) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= A.size(); i++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			al.add(ar);
		}

		for (int i = 1; i < A.size(); i++) {
			al.get(A.get(i)).add(i);
			al.get(i).add(A.get(i));
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int maxVal = Integer.MIN_VALUE;
		int len = al.size();
		int[] distance = new int[len];
		Arrays.fill(distance, Integer.MIN_VALUE);
		q.add(src);
		distance[src] = 0;
		while (!q.isEmpty()) {
			int n = q.poll();

			for (Integer i : al.get(n)) {

				if (distance[i] == Integer.MIN_VALUE) {
					q.add(i);
					distance[i] = distance[n] + 1;
				}
			}
		}
		int ver = 0;
		for (int j = 0; j < len; j++) {
			if (distance[j] > maxVal) {
				maxVal = distance[j];
				ver = j;
			}
		}

		return new Pair4(ver, maxVal);

	}
}

class Pair4 {

	int vertex;
	int distance;

	public Pair4(int v, int d) {
		vertex = v;
		distance = d;
	}
}
