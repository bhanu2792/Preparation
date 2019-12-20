import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

	ArrayList<Pair> al[];

	class Pair {
		int edge;
		int weight;

		public Pair(int e, int w) {
			edge = e;
			weight = w;
		}
	}

	public DijkstraAlgorithm(int v) {

		al = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			al[i] = new ArrayList<Pair>();
		}
	}

	public void add(DijkstraAlgorithm g, int u, int v, int w) {

		al[v].add(new Pair(u, w));
		al[u].add(new Pair(v, w));
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			int vertics = Integer.parseInt(inp[0]);
			int edge = Integer.parseInt(inp[1]);
			DijkstraAlgorithm g = new DijkstraAlgorithm(vertics);
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				int w = Integer.parseInt(inp[2]);
				g.add(g, u, v, w);
			}
			int s = Integer.parseInt(br.readLine());
			int[] ans = dijkstra(g, s);
			for (int i = 2; i < ans.length; i++) {
				System.out.println(ans[i]);
			}
		}
		br.close();
		bw.close();
	}

	public static int[] dijkstra(DijkstraAlgorithm g, int src) {
		int d[] = new int[g.al.length];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[src] = 0;
		PriorityQueue<Pair1> p = new PriorityQueue<Pair1>(g.al.length,new Pair1());
		p.add(new Pair1(0, src));

		while (!p.isEmpty()) {
			Pair1 s = p.poll();
			int dist = s.distance;
			int ver = s.vertics;
			for (Pair q : g.al[ver]) {
				int v = q.edge;
				int w = q.weight;
				int newDis = dist + w;
				if (newDis < d[v]) {
					d[v] = newDis;
					p.add(new Pair1(newDis, v));
				}
			}
		}
		return d;
	}
}

 class Pair1 implements Comparator<Pair1> {
	int distance;
	int vertics;
	
	public Pair1() {
		
	}

	public Pair1(int dis, int vertics) {
		this.distance = dis;
		this.vertics = vertics;
	}

	@Override
	public int compare(Pair1 arg0, Pair1 arg1) {
		// TODO Auto-generated method stub
		if (arg0.distance < arg1.distance) {
			return -1;
		}
		if (arg0.distance > arg1.distance) {
			return 1;
		}
		return 0;
	}

}