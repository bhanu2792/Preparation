public class MergeSortLL {

	static ListNode head;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortLL list = new MergeSortLL();
		list.head = new ListNode(1);
		list.head.next = new ListNode(8);
		list.head.next.next = new ListNode(7);
		list.head.next.next.next = new ListNode(6);
		list.head.next.next.next.next = new ListNode(5);
		ListNode a = sortList(head);
		printlist(a);

	}

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int Data) {
			this.val = Data;
			next = null;
		}
	}

	static void printlist(ListNode node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}

	public static ListNode sortList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}

		ListNode mid = getMiddle(A);
		ListNode nextOfMid = mid.next;
		mid.next = null;

		ListNode left = sortList(A);
		ListNode right = sortList(nextOfMid);

		ListNode sorted = sort(left, right);

		return sorted;

	}

	public static ListNode sort(ListNode A, ListNode B) {

		ListNode res = null;

		if (A == null) {
			return B;
		}

		if (B == null) {
			return A;
		}

		if (A.val <= B.val) {
			res = A;
			res.next = sort(A.next, B);
		} else {
			res = B;
			res.next = sort(A, B.next);
		}

		return res;
	}

	public static ListNode getMiddle(ListNode A) {
		if (A == null) {
			return A;
		}

		ListNode s = A;
		ListNode f = A.next;

		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}

		return s;
	}

}
