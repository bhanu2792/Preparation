public class SwapInPainLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int Data) {
			this.data = Data;
			next = null;
		}
	}
	
	public static ListNode swapInPair(ListNode A) {
		
		ListNode head = A.next;
		ListNode prev = null;
	
		while (A != null && A.next != null) {
			
			ListNode temp = A.next;
			A.next = A.next.next;
			temp.next = A;
			
			if (prev != null) 
				prev.next = temp;
			
				prev = A;
				A = A.next;
			
		}
		
		return head;
		
		
	}

}
