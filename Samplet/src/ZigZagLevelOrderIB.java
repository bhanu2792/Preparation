import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZagLevelOrderIB {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

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
			zigzagLevelOrder(root);
			bw.write("\n");
		}
		br.close();
		bw.close();

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

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Deque<TreeNode> dq = new LinkedList<TreeNode>();
		if (A == null) {
			return res;
		}

		boolean isFlag = false;
		dq.addFirst(A);

		while (!dq.isEmpty()) {

			int size = dq.size();
			TreeNode n;
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {

				if (isFlag) {
					n = dq.removeFirst();
					al.add(n.data);
					if (n.right != null) {
						dq.addLast(n.right);
					}

					if (n.left != null) {
						dq.addLast(n.left);
					}

				} else {

					n = dq.removeLast();
					al.add(n.data);
					if (n.left != null) {
						dq.addFirst(n.left);
					}
					if (n.right != null) {
						dq.addFirst(n.right);
					}

				}

			}
			res.add(al);
			isFlag = !isFlag;
		}

		return res;

	}

}
