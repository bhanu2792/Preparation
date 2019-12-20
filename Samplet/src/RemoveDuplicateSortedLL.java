public class RemoveDuplicateSortedLL {

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

	public static ListNode removeDup(ListNode A) {
		
		ListNode cur = A;
		
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}		
		return A;
	}
	
}
