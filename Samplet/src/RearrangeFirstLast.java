public class RearrangeFirstLast {

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

	public static ListNode rearrange(ListNode A) {

		ListNode slow = A, fast = slow.next; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        }
		
		fast = slow.next;
		slow.next = null;
		slow = A;
		
		fast = reverse(fast);
		ListNode fast_next = fast;
		ListNode slow_next = slow;
		while (slow != null && fast != null) {
			fast_next = fast.next;
			slow_next = slow.next;
			fast.next = slow.next;
			slow.next = fast;
			
			fast = fast_next;
			slow = slow_next;
		}
		
		return A;
	}

	public static ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}
