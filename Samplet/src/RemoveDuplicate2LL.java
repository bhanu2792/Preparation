public class RemoveDuplicate2LL {

	static ListNode head;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicate2LL list = new RemoveDuplicate2LL();
		list.head = new ListNode(50);
		list.head.next = new ListNode(30);
		list.head.next.next = new ListNode(30);
		list.head.next.next.next = new ListNode(45);
		list.head.next.next.next.next = new ListNode(5);
		list.head.next.next.next.next.next = new ListNode(12);
		;

		ListNode l = list.removeLL(head);
		printlist(l);
	}

	static void printlist(ListNode node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
	}

	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int Data) {
			this.data = Data;
			next = null;
		}
	}

	public static ListNode removeLL(ListNode A) {

		if (A == null || A.next == null) {
			return A;
		}
		ListNode cur = A;
		ListNode prev = null;
		ListNode head = A;

		while (cur != null && cur.next != null) {

			if (cur.data != cur.next.data) {
				if (prev != null) {
					prev.next = cur;
				} else {
					head = cur;
				}
				prev = cur;

			} else {
				while (cur != null && cur.next != null && cur.data == cur.next.data) {
					cur = cur.next;
				}

			}
			cur = cur.next;
		}
		
		if (prev == null) {
			System.out.print("Return Null");
			return cur;
		}
		
		if (cur != null) {
			prev.next = cur;
		} else {
			prev.next = null;
		}

		return head;
	}
}
