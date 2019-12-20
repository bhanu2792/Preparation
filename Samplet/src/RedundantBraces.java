import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int s =	isRedundantBraces("(a+b+(c+d))");
	    System.out.println(s);
	}

	public static int isRedundantBraces(String A) {
		int len = A.length();
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < len; i++) {

			if (A.charAt(i) == ')') {
				char top = st.peek();
				st.pop();
				boolean isRedundant = true;
				while (top != '(') {
					if (top == '+' || top == '-' || top == '*' || top == '/') {
						isRedundant = false;
					}

					top = st.peek();
					st.pop();
				}

				if (isRedundant) {
					return 1;
				}
			} else {
				st.push(A.charAt(i));
			}

		}

		return 0;
	}

}
