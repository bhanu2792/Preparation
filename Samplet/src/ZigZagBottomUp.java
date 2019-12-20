import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagBottomUp {
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
			bottomUpLevelOrder(root, bw);
		}
		br.close();
		bw.close();
	}

	public static void bottomUpLevelOrder(Node root, BufferedWriter bw) throws IOException {
		Stack<Node> st = new Stack<Node>();
		Deque<Node> q = new LinkedList<Node>();
		boolean isFlag = false;
		q.addFirst(root);
		st.push(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n;
				if (isFlag) {
					 n = q.removeFirst();
					if (n.left != null) {
						q.addLast(n.left);
						st.push(n.left);
					}
					if (n.right != null) {
						q.addLast(n.right);
						st.push(n.right);
					}
				} else {
					 n = q.removeLast();
					if (n.right != null) {
						q.addFirst(n.right);
						st.push(n.right);
					}
					if (n.left != null) {
						q.addFirst(n.left);
						st.push(n.left);
					}
				}
			}
			isFlag = !isFlag;
		}

		while (!st.isEmpty()) {
			bw.write(st.pop().data + " ");
		}
		bw.write("\n");
	}
}