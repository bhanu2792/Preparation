import java.util.ArrayList;

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1(int x) {
		val = x;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class sortedListToBST {
	
	public static void main(String[] arg0) {
		
	}

	public TreeNode1 sortedListToBST(ListNode a) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
		int count = countNode(a, ar);
		
		if (count == 0) {
			return null;
		}
		return constructBST(0, count-1, ar);
	}

	public TreeNode1 constructBST(int start, int end, ArrayList<Integer> ar) {

		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		TreeNode1 root = new TreeNode1(ar.get(mid));
		root.left = constructBST(start, mid - 1, ar);
		root.right = constructBST(mid + 1, end, ar);

		return root;

	}

	public int countNode(ListNode a, ArrayList<Integer> ar) {
		ListNode temp = a;
		int count = 0;
		while (temp != null) {
			ar.add(temp.val);
			count++;
			temp = temp.next;
		}
		return count;
	}
}
