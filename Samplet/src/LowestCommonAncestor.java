import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LowestCommonAncestor {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Node root = null;
			String[] inp = br.readLine().split("\\s+");
			int len = Integer.parseInt(inp[0]);
			int query = Integer.parseInt(inp[1]);
			inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				int data = Integer.parseInt(inp[i]);
				root = insert(root, data);
			}
			for (int j = 0; j < query; j++) {
				inp = br.readLine().split("\\s+");
				int x = Integer.parseInt(inp[0]);
				int y = Integer.parseInt(inp[1]);
				int ans = lowestCA(root, x, y);
				bw.write(ans + " ");
			}
			bw.write("\n");
		}
		br.close();
		bw.close();
	}

	public static int lowestCA(Node root, int x, int y) {
		if (root == null) {
			return 0;
		}

		if (root.data > x && root.data > y) {
			return lowestCA(root.left, x, y);
		}

		if (root.data < x && root.data < y) {
			return lowestCA(root.right, x, y);

		}

		return root.data;
	}

}
