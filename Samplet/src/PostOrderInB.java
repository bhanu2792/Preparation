import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class PostOrderInB {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	public static TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		} else {
			TreeNode cur;
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
			TreeNode root = null;
			int len = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				int data = Integer.parseInt(inp[i]);
				root = insert(root, data);
			}
			postOrder(root);
			bw.write("\n");
		}
		br.close();
		bw.close();
	}

	public static ArrayList<Integer> postOrder(TreeNode A) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A == null)
			return res;

		TreeNode cur = A;
		while (cur != null || !st.isEmpty()) {
			while (cur != null) {
				st.push(cur);
				st.push(cur);
				cur = cur.left;
			}

			cur = st.pop();

			if (!st.isEmpty() && cur == st.peek()) {
				cur = cur.right;
			} else {
				res.add(cur.data);
			}
		}
		
		return res;
	}
}