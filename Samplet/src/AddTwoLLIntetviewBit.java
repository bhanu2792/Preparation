public class AddTwoLLIntetviewBit {

	static ListNode head1, head2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddTwoLLIntetviewBit list = new AddTwoLLIntetviewBit();
		list.head1 = new ListNode(1);
		list.head1.next = new ListNode(1);
		list.head1.next.next = new ListNode(1);
		list.head1.next.next.next = new ListNode(1);
		list.head1.next.next.next.next = new ListNode(1);

		System.out.print("First List is ");
		list.printlist(head1);

		// creating seconnd list 
		list.head2 = new ListNode(9); 
		list.head2.next = new ListNode(9);
		list.head2.next.next = new ListNode(9);
		list.head2.next.next.next = new ListNode(9);
		list.head2.next.next.next.next = new ListNode(9);
		list.head2.next.next.next.next.next = new ListNode(9);

		System.out.print("Second List is ");
		list.printlist(head2);

		ListNode ans = add(head1, head2);

		System.out.print("Resultant List is ");
		list.printlist(ans);

	}

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int Data) {
			this.val = Data;
			next = null;
		}
	}

	void printlist(ListNode node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}

	public static ListNode add(ListNode A, ListNode B) {
		int sum = 0;
		int carry = 0;
		int total = 0;

		if (A == null) {
			return B;
		}

		if (B == null) {
			return A;
		}

		ListNode C = reverse(A);
		ListNode D = reverse(B);
		ListNode F = null;
		ListNode cur = null;
		while (C != null && D != null) {
			sum = C.val + D.val + carry;
			carry = sum / 10;
			total = sum % 10;

			if (F == null) {
				ListNode E = new ListNode(total);
				F = E;
				cur = E;
			} else {
				ListNode G = new ListNode(total);
				cur.next = G;
				cur = G;
			}
			C = C.next;
			D = D.next;
		}

		while (C != null) {
			sum = carry + C.val;
			carry = sum / 10;
			total = sum % 10;
			ListNode G = new ListNode(total);
			cur.next = G;
			cur = G;
			C = C.next;
		}

		while (D != null) {
			sum = carry + D.val;
			carry = sum / 10;
			total = sum % 10;
			ListNode G = new ListNode(total);
			cur.next = G;
			cur = G;
			D = D.next;
		}

		if (carry > 0) {
			ListNode G = new ListNode(carry);
			cur.next = G;
			cur = G;
		}

		F = reverse(F);

		return F;
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
