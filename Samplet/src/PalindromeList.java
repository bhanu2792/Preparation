public class PalindromeList {

    ListNode head;
	
	class ListNode {
		char data;
		ListNode next;

		public ListNode(char Data) {
			this.data = Data;
			next = null;
		}

	}
	public static void main(String[] args) {

	}
	
	public void push(char new_data) 
    { 
        /* Allocate the Node & 
           Put in the data */
        ListNode new_node = new ListNode(new_data); 
  
        /* link the old list off the new one */
        new_node.next = head; 
  
        /* Move the head to point to new Node */
        head = new_node; 
    }

	public static void printList(ListNode ptr) 
    { 
        while (ptr != null) { 
            System.out.print(ptr.data + "->"); 
            ptr = ptr.next; 
        } 
        System.out.println("NULL"); 
    } 
	


	public static int isPalindrome(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = slow.next;
		slow.next = null;
		slow = A;

		fast = reverse(fast);

		while (slow != null && fast != null) {
			if (slow.data != fast.data) {
				return 0;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return 1;
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
