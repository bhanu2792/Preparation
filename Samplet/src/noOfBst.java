import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class noOfBst {

	static int min = Integer.MIN_VALUE;
	static int max = Integer.MAX_VALUE;

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

	public static Node insert(int[] arr, Node root, int i) {
		if (i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;

			root.left = insert(arr, root.left, 2 * i + 1);

			root.right = insert(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Node root = null;
			int len = Integer.parseInt(br.readLine());
			int ar[] = new int[len];
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				ar[i] = Integer.parseInt(inp[i]);
			}
			root = insert(ar, root, 0);
			int b = countBst(root, min, max, 0);

			bw.write(b + "\n");

		}
		br.close();
		bw.close();
	}

	public static int countBst(Node root, int min, int max, int sum) {

		if (root == null) {
			return sum+1;
		}

		if (root.data < min || root.data > max) {
			return 0;
		}

		if (root.data > min && root.data < max) {
			return sum+1;
		}
		countBst(root.left, min, root.data - 1, sum);
		countBst(root.right, root.data + 1, max, sum);
		return  sum; 
	}
}
