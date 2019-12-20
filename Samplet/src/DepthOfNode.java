import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DepthOfNode {

	   static class Node {
	        int data;
	        Node left;
	        Node right;
	        int depth;
	        public Node (int val){
	            data = val;
	            left = null;
	            right = null;
	            depth = 0;
	        }
	    }
	    
	    public static Node insert(Node root, int data, int d, BufferedWriter bw) throws IOException {
	        if(root == null) {
	        	bw.write(d+" ");
	            return new Node(data);
	        } else {
	            Node cur;
	            if(data <= root.data) {
	                cur = insert(root.left, data, d+1, bw);
	                root.left = cur;
	            } else {
	                cur = insert(root.right, data, d+1, bw);
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
            String[] inp=br.readLine().split("\\s+");
            for (int i =0; i<len; i++){
                int data = Integer.parseInt(inp[i]);
                root = insert(root, data, 0, bw);
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
	}
}
