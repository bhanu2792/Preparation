import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HeightTree {

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
    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
            int ans =  height(root);
            bw.write(ans+"\n"); 
        }
        bw.flush();
    }
    
    public static int height(Node root) {
    	
    	if (root == null) {
    		return 0;
    	}
    	
    	int left = height(root.left)+1;
    	int right = height(root.right)+1;
    	
    	return Math.max(left, right);
    }
}