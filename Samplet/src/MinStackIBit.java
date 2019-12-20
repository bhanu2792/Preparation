import java.util.Stack;

public class MinStackIBit {

	public static Stack<Integer> st = new Stack<Integer>();
	public static Stack<Integer> minSt = new Stack<Integer>();
	
	public MinStackIBit() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}
	
	public static void push(int x) {
		st.push(x);
		if (minSt.isEmpty() || x <= minSt.peek()) {
			minSt.push(x);
		}
	}

	public static void pop() {
		if (!st.isEmpty()) {
			int val = st.pop();
			if (val == minSt.peek()) {
				minSt.pop();
			}
		}
	}
	
	public static int top() {
		if (st.isEmpty()) {
			return -1;
		} else {
			return st.peek();
		}
	}
	
	public static int getMin() {
		if (minSt.isEmpty()) {
			return -1;
		} else {
			return minSt.peek();
		}
	}
}
