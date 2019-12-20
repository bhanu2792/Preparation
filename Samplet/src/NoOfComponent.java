import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class NoOfComponent {

	ArrayList<Integer> al[];

	@SuppressWarnings("unchecked")
	public NoOfComponent(int v) {

		al = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			al[i] = new ArrayList<Integer>();
		}
	}

	public void add(NoOfComponent g, int u, int v) {
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
			NoOfComponent g = new NoOfComponent(vertics);
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				g.add(g, u, v);
			}
			int ans = countConnectComponent(g, vertics+1);
			bw.write(ans-1 + "\n");
		}
		br.close();
		bw.close();
	}

	public static int countConnectComponent(NoOfComponent g, int v) {
		boolean[] isVisit = new boolean[v];
		int count = 0;
		for (int i = 0; i < v; i++) {
			if (isVisit[i] == false) {
				DFS(g, isVisit, i);
				count++;
			}

		}
		return count;
	}

	public static void DFS(NoOfComponent g, boolean[] isVisit, int v) {
		isVisit[v] = true;

		for (Integer k : g.al[v]) {
			if (!isVisit[k]) {
				DFS(g, isVisit, k);
			}
		}
	}
}
