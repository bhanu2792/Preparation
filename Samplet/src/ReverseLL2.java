public class ReverseLL2 {

	static ListNode head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseLL2 list = new ReverseLL2(); 
        list.head = new ListNode(1); 
        list.head.next = new ListNode(2); 
        list.head.next.next = new ListNode(3); 
        list.head.next.next.next = new ListNode(4); 
        list.head.next.next.next.next = new ListNode(5); 
        System.out.println("Input is "); 
        list.printlist(head); // print original list 
        System.out.println("Input over"); 
        list.reverseLL(head, 2,4); // rearrange list as per ques 
        System.out.println(""); 
        list.printlist(head); // print modified list 

	}
	
	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int Data) {
			this.data = Data;
			next = null;
		}
	}
	
	public static ListNode reverseLL(ListNode A, int B, int C) {
		if (B >= C || A == null) {
			return A;
		}
		
	    ListNode slow = A;
	    ListNode start = null;
	    int count = 1;
	    while (count < B) {
	    	start = slow;
	    	slow = slow.next;
	    	count++;
	    }
	    ListNode end = slow;
	    while (count < C) {
	    	end = end.next;
	    	count++;
	    }
	    ListNode cur = slow;
		ListNode prev = end.next;
		ListNode next = null;
		count = 0;
		while (cur != null && count <= C-B) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}

		if (start != null) {
		    start.next = prev;
		} else {
			return prev;
		}
		return A;
	}
	
	void printlist(ListNode node) { 
        if (node == null) { 
            return; 
        } 
        while (node != null) { 
            System.out.print(node.data + " -> "); 
            node = node.next; 
        } 
    }
	
	
	public static ListNode reverse(ListNode head, int pos, int n) {
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
