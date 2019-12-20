public class RotateLL {

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

	public static ListNode rotateLL(ListNode A, int B) {
		ListNode slow = A;
		ListNode fast = A;
		ListNode head = A;
		int count = 0;
		while (fast.next != null && count != B) {
			fast = fast.next;
			count++;
		}
		
		if (count != B) {
			if (count+1 == B) {
				return head;
			} else {
			    slow = A;
			    fast = A;
			    int n = B%(count+1);
			    count = 0;
			    while (fast.next != null && count != n) {
					fast = fast.next;
					count++;
				}
			}
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		if (fast != slow) {
			head = slow.next;
			slow.next = null;
			fast.next = A;
		}
		return head;
	}

}
