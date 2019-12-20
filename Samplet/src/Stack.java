import java.util.Scanner;

public class Stack {

	static int[] arr = new int[100];
	static int top = -1;
	public static void main (String[] arg0) {
		
		Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.nextLine();
        String s1 = "";
        for (int i=0; i<input; i++){
        	s1 = scan.nextLine();
            String[] sub = s1.split(" ");
            if (sub[0].equals("push")) {
            	push(Integer.parseInt(sub[1]));
            } else {
            	pop();
            }
            
        }
	}
	
	public static void push(int num) {
		arr[++top] = num;
	}
	
	public static void pop() {
		if (top != -1) {
			System.out.println(arr[top]);
			top--;
		} else {
			System.out.println("Empty");
		}
		
	}
}
