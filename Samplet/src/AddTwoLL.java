public class AddTwoLL {

	static ListNode head1;
	static ListNode head2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoLL list = new AddTwoLL(); 
		list.head1 = new ListNode(1);
		/*
		 * System.out.print("First List is "); list.printlist(head1);
		 */
     // creating seconnd list 
        list.head2 = new ListNode(9); 
        list.head2.next = new ListNode(9); 
        list.head2.next.next = new ListNode(9); 
        list.head2.next.next.next = new ListNode(9); 
        list.head2.next.next.next.next = new ListNode(9); 
        list.head2.next.next.next.next.next = new ListNode(9); 
        
		/*
		 * System.out.print("Second List is "); list.printlist(head2);
		 */ 
        
        
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
		
		ListNode F = null;
		ListNode cur = null;
		while (A != null && B != null) {
			sum = A.val + B.val + carry;
			carry = sum/10;
			total = sum%10;
			
			if (F == null) {
				ListNode E = new ListNode(total);
				F = E;
				cur = E;
			} else {
				ListNode G = new ListNode(total);
				cur.next = G;
				cur = G;
			}
			A=A.next;
			B=B.next;
		}
		
		while (A != null) {
			sum = carry + A.val;
			carry = sum/10;
			total = sum%10;
			ListNode G = new ListNode(total);
			cur.next = G;
			cur = G;
			A = A.next;
		}
		
		while (B != null) {
			sum = carry + B.val;
			carry = sum/10;
			total = sum%10;
			ListNode G = new ListNode(total);
			cur.next = G;
			cur = G;
			B = B.next;
		}
		
		if (carry > 0) {
			ListNode G = new ListNode(carry);
			cur.next = G;
			cur = G;
		}
		
		return F;
	}
}
