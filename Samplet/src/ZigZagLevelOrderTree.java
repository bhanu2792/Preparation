import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZagLevelOrderTree {

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
			zigZagLevelOrder(root, bw);
		}
		br.close();
		bw.close();
	}

	public static void zigZagLevelOrder(Node root, BufferedWriter bw) throws IOException {
		Deque<Node> dq = new LinkedList<Node>();

		if (root == null) {
			return;
		}

		dq.add(root);
		boolean isOdd = false;
		while (!dq.isEmpty()) {
			int size = dq.size();

			for (int i = 0; i < size; i++) {
				Node cur = null;
				if (isOdd) {
					cur = dq.removeFirst();
					if (cur.right != null) {
						dq.addLast(cur.right);
					}
					if (cur.left != null) {
						dq.addLast(cur.left);
					}
					bw.write(cur.data + " ");
				} else {
					cur = dq.removeLast();
					if (cur.right != null) {
						dq.addFirst(cur.right);
					}
					if (cur.left != null) {
						dq.addFirst(cur.left);
					}
					bw.write(cur.data + " ");
				}
			}
			isOdd = !isOdd;
		}
		bw.write("\n");
	}
}
