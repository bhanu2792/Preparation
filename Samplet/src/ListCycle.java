public class ListCycle {
	static ListNode head; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListCycle list = new ListCycle();
		list.head = new ListNode(50); 
        list.head.next = new ListNode(20); 
        list.head.next.next = new ListNode(15); 
        list.head.next.next.next = new ListNode(4); 
        list.head.next.next.next.next = new ListNode(10); 
  
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next; 
        
       ListNode l = list.loopInLL(head);
       if (l!=null) {
    	   System.out.println(l.data);
       } else {
       System.out.println("Null");
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
	
	public static ListNode loopInLL(ListNode A) {
		if (A == null) {
			return null;
		}
		boolean loopFound = false;
		ListNode slow = A;
		ListNode fast = A;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = A;
				loopFound = true;
				break;
			}
		}
		
		while (loopFound && slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		if (loopFound) {
			return slow;
		}
		
		
		return null;
	}
}
