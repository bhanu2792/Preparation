public class RemoveNthNodeLL {

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

	public static ListNode removeNthNode(ListNode A, int B) {
		ListNode slow = A;
		ListNode fast = A;
		int count = 0;
		while (fast != null && count != B) {
			  fast = fast.next;
			  count++;
		}
		if (fast == null || fast.next == null) {
			A = A.next;
			slow.next = null;
			return A;
		}
		
		while (fast != null && fast.next != null) {
			   slow = slow.next;
			   fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return A;
		
	}
	
}
