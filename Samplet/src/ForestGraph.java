import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ForestGraph {

	ArrayList<Integer> al[];

	@SuppressWarnings("unchecked")
	public ForestGraph(int v) {

		al = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			al[i] = new ArrayList<Integer>();
		}
	}

	public void add(ForestGraph g, int u, int v) {
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
			ForestGraph g = new ForestGraph(vertics);
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				g.add(g, u, v);
			}
			boolean ans = isCycle(g, vertics + 1);
			if (ans) {
				bw.write("No" + "\n");
			} else {
				bw.write("Yes" + "\n");
			}
		}
		br.close();
		bw.close();
	}

	public static boolean isCycle(ForestGraph g, int v) {
		boolean[] isVisit = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (isVisit[i] == false) {
				if (DFS(g, isVisit, i, -1)) {
					return true;
				}

			}

		}
		return false;
	}

	public static boolean DFS(ForestGraph g, boolean[] isVisit, int v, int p) {
		isVisit[v] = true;

		for (Integer k : g.al[v]) {
			if (k != p) {
				if (isVisit[k]) {
					return true;
				} else {
					if (DFS(g, isVisit, k, v)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
