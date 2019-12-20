import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NodeDistanceK {
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
			int src = Integer.parseInt(inp[1]);
			int dis = Integer.parseInt(inp[2]);
			inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				int data = Integer.parseInt(inp[i]);
				root = insert(root, data);
			}
			printKdisNode(root, src, dis, 0);
		}
		br.close();
		bw.close();
	}

	public static void printDownKdis(Node root, int c, int k) {
		if (root == null) {
			return;
		}

		if (c == k) {
			System.out.print(root.data + "\n");
			return;
		}

		printDownKdis(root.left, c + 1, k);
		printDownKdis(root.right, c + 1, k);

	}

	public static int printKdisNode(Node root, int src, int k, int co) {
		if (root == null) {
			return 0;
		}

		if (root.data == src) {
			printDownKdis(root, 0, k);
			return 1;
		}

		int lf = printKdisNode(root.left, src, k, co + 1);
		int rf = printKdisNode(root.right, src, k, co + 1);

		if (lf == 1) {
			int d = k - co + 1;
			if (d == k) {
				System.out.println(root.data + " ");
			}
			if (d > 0) {
				printDownKdis(root.right, 0, k - d + 1);
			}
		}

		if (rf == 1) {
			int d = k - co + 1;
			if (d == k) {
				System.out.println(root.data + " ");
			}
			if (d > 0) {
				printDownKdis(root.left, 0, k - d + 1);
			}
		}

		if (lf == 1 || rf == 1) {
			return 1;
		}
		return 0;
	}
}