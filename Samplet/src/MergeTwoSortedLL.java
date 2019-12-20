public class MergeTwoSortedLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(char Data) {
			this.val = Data;
			next = null;
		}

	}

	
	public static ListNode mergeList(ListNode A, ListNode B) {
		ListNode p1 = A;
		ListNode p2 = B;
		ListNode prev = null;
        ListNode head =null;
		if (p1 == null) {
			return p2;
		}
		
		if (p2 == null) {
			return p1;
		}
		if (p1.val > p2.val) {
			head = p2;
			prev = p2;
			p2 = p2.next;
		} else { 
			head = p1;
			prev = p1;
			p1 = p1.next;
		}
		
		
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				prev.next = p2;
				prev = p2;
				p2 = p2.next;
			} else {
				prev.next = p1;
				prev = p1;
				p1 = p1.next;
			}
		}
		
		if (p1 != null) {
			prev.next = p1;
		}
		
		if (p2 != null) {
			prev.next = p2;
		}
		
		return head;
	}
}
