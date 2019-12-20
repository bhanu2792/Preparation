import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestNo {

	public static void main(String[] args) {
		// 1, 3, 0, 2, 5
		// 1, 6, 4, 10, 2, 5
		// 4, 5, 2, 10, 8
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(4);
		al.add(5);
		al.add(2);
		al.add(10);
		al.add(8);
		//al.add(5);
		
		ArrayList<Integer> a = smallest(al);
		for (int i =0; i< a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	public static ArrayList<Integer> smallest(ArrayList<Integer> A) {

		int len = A.size();
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {

			while (!st.isEmpty() && st.peek() >= A.get(i)) {
				st.pop();

			}
			if (!st.isEmpty()) {
				ar.add(st.peek());
			} else {
				ar.add(-1);
			}
			st.push(A.get(i));

		}
		
		return ar;

	}

}
