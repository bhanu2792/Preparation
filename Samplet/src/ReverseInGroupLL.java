public class ReverseInGroupLL {

	static ListNode head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseInGroupLL list = new ReverseInGroupLL();
		list.head = new ListNode(1); 
        list.head.next = new ListNode(2); 
        list.head.next.next = new ListNode(3); 
        list.head.next.next.next = new ListNode(4); 
        list.head.next.next.next.next = new ListNode(5); 
        
        reverseKsize(head, 2);
        
        list.printlist(head);
	}

	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int Data) {
			this.data = Data;
			next = null;
		}
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
	
	public static ListNode reverseKsize(ListNode A, int B) {
		ListNode cur = A;
		ListNode newNext = null;
		ListNode prev = null;
		int count = 0;
		
		while (cur != null && count < B) {
			newNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = newNext;
			count++;
			System.out.println("cur data is" + cur.data);
		}
		
		
			
		if (newNext != null) {
			System.out.println("next data is" + newNext.data);
			A.next = reverseKsize(newNext, B);
		}	
			
		return prev;
	}
}
