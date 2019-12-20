import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CompleteBinaryTree {

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
			int len = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				int data = Integer.parseInt(inp[i]);
				root = insert(root, data);
			}
			int noOfNode = countNodes(root);
			boolean ans = isCompleteBST(root, noOfNode, 0, bw);
			System.out.println("ans is ->" + ans);
		}
		br.close();
		bw.close();
	}

	public static int countNodes(Node root) {

		if (root == null) {
			return 0;
		}

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static boolean isCompleteBST(Node root, int NoOfNode, int index, BufferedWriter bw) throws IOException {
		if (root == null) {
			return true;
		}

		if (index >= NoOfNode) {
			return false;
		}

		return (isCompleteBST(root.left, NoOfNode, 2 * index + 1, bw)
				&& isCompleteBST(root.right, NoOfNode, 2 * index + 2, bw));

	}
}
