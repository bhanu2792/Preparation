import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PathSumIB {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
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
			hasPathSum(root, 7);
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
			if (data <= root.val) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static int hasPathSum(TreeNode A, int B) {

		if (A == null) {
			return 0;
		}

		if (A.left == null && A.right == null && A.val == B) {
			return 1;
		} else if (hasPathSum(A.left, B - A.val) == 1 || hasPathSum(A.right, B - A.val) == 1) {
			return 1;
		} else
			return 0;
	}

}
