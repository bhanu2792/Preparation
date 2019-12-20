import java.util.ArrayList;
import java.util.Stack;

public class EvaluteExpression {

	public static void main(String[] args) {
		// ["2", "1", "+", "3", "*"]
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("2");
		ar.add("2");
		ar.add("/");
		//ar.add("/");
		//ar.add("+");
		
		int ans = evaluteExpression(ar);
		System.out.println(ans);
	}

	public static int evaluteExpression(ArrayList<String> A) {
		int len = A.size();
		Stack<Integer> st = new Stack<Integer>();
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < len; i++) {
			if (isOperator(A.get(i))) {
				a = st.pop();
				b = st.pop();
				c = evaluate(b, a, A.get(i));
				st.push(c);
			} else {
				st.push(Integer.parseInt(A.get(i)));
			}
		}

		return st.peek();
	}

	public static int evaluate(int a, int b, String op) {
		int num = 0;
		switch (op) {
		case "+":
			num = a + b;
			break;
		case "-":
			num = a - b;
			break;
		case "*":
			num = a * b;
			break;
		case "/":
			num = a / b;
			break;
		default:
			break;
		}

		return num;

	}

	public static boolean isOperator(String c) {
		return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
	}

}
