import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	static int count = 1;
	ArrayList<Integer> al[];

	public Graph(int v) {

		al = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			al[i] = new ArrayList<Integer>();
		}
	}

	public void add(Graph g, int u, int v) {
		al[u].add(v);
		al[v].add(u);
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
			Graph g = new Graph(vertics);
			bw.write("Test Case #"+count+":"+"\n");
			count++;
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				g.add(g, u, v);
			}
			int query = Integer.parseInt(br.readLine());
			for (int i = 0; i < query; i++) {
				inp = br.readLine().split("\\s+");
				int src = Integer.parseInt(inp[0]);
				int des = Integer.parseInt(inp[1]);
				boolean b = BFS(g, src, des, vertics);
				if (b) {
					bw.write("Yes" + "\n");
				} else {
					bw.write("No" + "\n");
				}
			}

		}
		br.close();
		bw.close();
	}

	public static boolean BFS(Graph g, int src, int des, int size) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] isVisit = new boolean[g.al.length];
		q.add(src);
		isVisit[src] = true;

		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == des) {
				return true;
			}
			for (Integer i : g.al[n]) {

				if (isVisit[i] == false) {
					q.add(i);
					isVisit[i] = true;
					if (i == des) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
