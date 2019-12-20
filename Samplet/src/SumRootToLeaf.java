import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumRootToLeaf {

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
			long sum = countNodes(root, 0);
			bw.write(sum + "\n");
		}
		br.close();
		bw.close();
	}

	public static int countDigit(int no) {
		if (no < 10) {
            return 10;
        } else if (no >= 10 && no < 100) {
            return 100;
        } else if (no >= 100 && no < 1000) {
            return 1000;
        } else if (no >= 1000 && no < 10000){
            return 10000;
        } else {
        	return 100000;
        }
	}

	public static long countNodes(Node root, long sum) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			sum = (sum * countDigit(root.data)) % 1000000007 + (root.data % 1000000007);
			return sum;
		}

		return countNodes(root.left, (sum * countDigit(root.data)) % 1000000007 + (root.data % 1000000007))
				+ countNodes(root.right, (sum * countDigit(root.data)) % 1000000007 + (root.data % 1000000007));
	}
}
