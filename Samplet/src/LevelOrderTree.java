import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree {

	   static class Node {
	        int data;
	        Node left;
	        Node right;
	        
	        public Node (int val){
	            data = val;
	            left = null;
	            right = null;
	        }
	    }
	    
	    public static Node insert(Node root, int data) {
	        if(root == null) {
	            return new Node(data);
	        } else {
	            Node cur;
	            if(data < root.data) {
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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            Node root = null;
            int len = Integer.parseInt(br.readLine());
            String[] inp=br.readLine().split(" ");
            for (int i =0; i<len; i++){
                int data = Integer.parseInt(inp[i]);
                root = insert(root, data);
            }
            levelOrder(root);
            bw.write(System.lineSeparator());
        }
        bw.flush();
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(Node A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if (A == null) {
			return res;
		}
		ArrayList<Integer> ls = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(A);
		ls.add(A.data);
		res.add(ls);
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int i =0; i<size; i++) {
				Node n = q.poll();
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
				ans.add(n.data);
				System.out.print(n.data+" ");	
			}
			res.add(ans);
			System.out.println();	
		}
		return res;
	}
}
