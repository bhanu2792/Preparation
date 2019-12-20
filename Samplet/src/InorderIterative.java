import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class InorderIterative {

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
            if(data <= root.data) {
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            Node root = null;
            int len = Integer.parseInt(br.readLine());
            String[] inp=br.readLine().split("\\s+");
            for (int i =0; i<len; i++){
                int data = Integer.parseInt(inp[i]);
                root = insert(root, data);
            }
            inOrder(root, bw);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
    
    public static void inOrder(Node root, BufferedWriter bw) throws IOException {
    	Stack<Node> st = new Stack<Node>();
        if (root == null)
            return;
        
        Node cur = root;
        while (cur != null || !st.isEmpty()) {

        	while (cur!= null) {
        		st.push(cur);
        		cur = cur.left;
        	}
        	cur = st.pop();
        	System.out.print(cur.data+ " ");

        	cur = cur.right;        	
        }
    }
    
    public static void preOrder(Node root, BufferedWriter bw) throws IOException {
    	Stack<Node> st = new Stack<Node>();
        if (root == null)
            return;
        
        st.push(root);
        while (!st.isEmpty()) {
        	Node cur = st.pop();
        	System.out.print(cur.data+ " ");
        	
        	if (cur.right!= null) {
        		st.push(cur.right);        		
        	}
        	
        	if (cur.left!= null) {
        		st.push(cur.left);        		
        	}
        }
    }
}