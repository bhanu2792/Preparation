
import java.util.Scanner;

class TreeNode {
	static TreeNode root;
	static int height;
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class ContestQue6 {
	public static void buildTree(int data) {
		TreeNode n1 = new TreeNode(data);
		if (TreeNode.root == null) {
			TreeNode.root = n1;
			System.out.print(TreeNode.height + " ");
			return;
		}
		TreeNode ptr = TreeNode.root;
		TreeNode prev = null;
		int height = 0;
		while (ptr != null) {
			height++;
			prev = ptr;
			if (data > ptr.data)
				ptr = ptr.right;
			else
				ptr = ptr.left;
		}
		if (data > prev.data)
			prev.right = n1;
		else
			prev.left = n1;
		if (height > TreeNode.height)
			TreeNode.height = height;
		System.out.print(TreeNode.height + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int N = sc.nextInt();
			TreeNode.root = null;
			TreeNode.height = 0;
			for (int i = 0; i < N; i++) {
				int data = sc.nextInt();
				buildTree(data);
			}
			System.out.println();
			T--;
		}
	}

}
