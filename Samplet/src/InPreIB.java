import java.util.ArrayList;
import java.util.HashMap;

public class InPreIB {

  class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
          val = x;
          left=null;
          right=null;
         }
     }
  
  public static void main(String[] arg0) {
    InPreIB ob = new InPreIB();
    ArrayList<Integer> A = new ArrayList<Integer>();
    A.add(2);
    A.add(1);
    A.add(3);
  //  A.add(5);
  //  A.add(1);
    ArrayList<Integer> B = new ArrayList<Integer>();
    B.add(3);
    B.add(2);
    B.add(1);
   // B.add(1);
   // B.add(5);
    ob.buildTree(A, B);
    
  }
  
  
  static int index =0;
  public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
    HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
    
    int size = B.size();
    for (int i =0; i<size; i++){
        hs.put(B.get(i), i);
    }
    index = size-1;
   return constructTree(hs,A,B,0,size-1);
}

  public TreeNode constructTree(HashMap<Integer, Integer> hs,ArrayList<Integer> pre, ArrayList<Integer> in, int start, int end){
    
    if (start > end){
        return null;
    }
    TreeNode root = new TreeNode(pre.get(index--));
    System.out.println(root.val);
    if (start == end){
        return root;
    }
    int idx = hs.get(root.val);
    
   
    root.right = constructTree(hs, pre, in ,idx+1, end);
    root.left = constructTree(hs, pre, in ,start, idx-1);
    
    return root;
}
}
