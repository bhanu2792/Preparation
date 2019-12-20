import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {

	static Stack<Integer> st1 = new Stack<Integer>();
	static Stack<Integer> st2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.nextLine();
        String s1 = "";
        for (int i=0; i<input; i++){
            s1 = scan.nextLine();
            String[] sub = s1.split(" ");
            if (sub[0].equals("Enqueue")) {
            	enqueue(Integer.parseInt(sub[1]));
            } else {
            	dequeue();
            }
        }
	}
	
	public static void enqueue(int x) {
		st1.push(x);
	}

    public static void dequeue() {	
    	if (st2.isEmpty()) {
    		if (!st1.isEmpty()) {
    			int size = st1.size();
    			for (int i=0; i<size; i++) {
    				 st2.push(st1.pop());
    			}
    			System.out.println(st2.pop());
    		} else {
    			System.out.println("Empty");
    		}
    		
    	} else {
    		 System.out.println(st2.pop());
    	}
	}
}
