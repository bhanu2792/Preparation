import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTree {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
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
			TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<Integer, ArrayList<Integer>>();
			verticalOrder(root, 0, hm);
			printVerticalTree(hm, bw);
		}
		br.close();
		bw.close();
	}

	public static void verticalOrder(Node root, int v, TreeMap<Integer, ArrayList<Integer>> hm) {

		if (root == null) {
			return;
		}

		if (hm.containsKey(v)) {
			ArrayList<Integer> ar = hm.get(v);
			ar.add(root.data);
			Collections.sort(ar);
			hm.put(v, ar);
		} else {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			ar.add(root.data);
			hm.put(v, ar);
		}

		if (root.left != null) {
			verticalOrder(root.left, v - 1, hm);
		}

		if (root.right != null) {
			verticalOrder(root.right, v + 1, hm);
		}
	}

	public static void printVerticalTree(TreeMap<Integer, ArrayList<Integer>> hm, BufferedWriter bw) throws IOException {
		for (Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
			ArrayList<Integer> arr = hm.get(entry.getKey());
			int len = arr.size();
			for (int i = 0; i < len; i++) {
				bw.write(arr.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.write("\n");
	}
}
