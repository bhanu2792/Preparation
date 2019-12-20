import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DiameterTree {

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

	static class A {
		int ans = Integer.MIN_VALUE;
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
			int len = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				int data = Integer.parseInt(inp[i]);
				root = insert(root, data);
			}
			findDiameter(root, bw);
		}
		br.close();
		bw.close();
	}

	public static void findDiameter(Node root, BufferedWriter bw) throws IOException {
		A a = new A();
		calculateDiameter(root, a);
		bw.write(a.ans + "\n");
	}

	public static int calculateDiameter(Node root, A a) {
		if (root == null) {
			return 0;
		}

		int lheight = calculateDiameter(root.left, a);
		int rheight = calculateDiameter(root.right, a);

		a.ans = Math.max(a.ans, 1 + lheight + rheight);

		return 1 + Math.max(lheight, rheight);
	}
}