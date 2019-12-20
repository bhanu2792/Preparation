import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

	public static void main(String[] args) {
		// 12, 1, 78, 90, 57, 89, 56 
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(12);
		al.add(1);
		al.add(78);
		al.add(90);
		al.add(57);
		al.add(89);
		al.add(56);
		slidingWindowMax(al, 3);

	}
	
	public static ArrayList<Integer> slidingWindowMax(ArrayList<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Deque<Integer> de = new LinkedList<Integer>();
		int len = A.size();
		int i =0;
		for (;i<B; i++) {
			while (!de.isEmpty() && A.get(i) >= A.get(de.peekLast())) {
				de.removeLast();
			}
			de.addLast(i);
		}
		
		for (;i<len; i++) {
			res.add(A.get(de.peek()));
			
			while (!de.isEmpty() && de.peek() <= i-B) {
				   de.removeFirst();
			}
			
			while (!de.isEmpty() && A.get(i) >= A.get(de.peekLast())) {
				   de.removeLast();
			}
			
			de.addLast(i);
		}
		res.add(A.get(de.peek()));
		return res;
	}

}
