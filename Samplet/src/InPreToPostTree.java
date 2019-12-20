import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class InPreToPostTree {
	static int preIndex = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int len = Integer.parseInt(br.readLine());
			int pre[] = new int[len];
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				pre[i] = Integer.parseInt(inp[i]);
			}
			int in[] = new int[len];
			inp = br.readLine().split("\\s+");
			for (int j = 0; j < len; j++) {
				in[j] = Integer.parseInt(inp[j]);
			}
			printPostMain(in, pre, bw);
			preIndex = 0;
			bw.newLine();
		}
		br.close();
		bw.close();
	}

	static void printPostMain(int[] in, int[] pre, BufferedWriter bw) throws IOException {
		int n = pre.length;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
			hm.put(in[i], i);

		postOrder(in, pre, 0, n - 1, hm, bw);
	}

	public static void postOrder(int[] in, int[] pre, int start, int end, HashMap<Integer, Integer> hm,
			BufferedWriter bw) throws IOException {

		if (start > end)
			return;

		int index = hm.get(pre[preIndex++]);

		postOrder(in, pre, start, index - 1, hm, bw);
		postOrder(in, pre, index + 1, end, hm, bw);

		bw.write(in[index] + " ");

	}
}
