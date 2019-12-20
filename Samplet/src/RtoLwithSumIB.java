import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class RtoLwithSumIB {

	//public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

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
			pathSum(root, 7);
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

	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (A == null) {
			return res;
		}

		hasPathSum(A, B, ar, res);

		return res;

	}

	public static void hasPathSum(TreeNode A, int B, ArrayList<Integer> ar, ArrayList<ArrayList<Integer>> res) {

		if (A == null) {
			return;
		}
		ar.add(A.val);
		if (A.left == null && A.right == null && A.val == B) {
			res.add(new ArrayList<Integer> (ar));
		}
		if (A.left != null) {
			hasPathSum(A.left, B - A.val, ar, res);
		}
		if (A.right != null) {
			hasPathSum(A.right, B - A.val, ar, res);
		}
		ar.remove(ar.size() - 1);
	}

}
