import java.util.ArrayList;

public class ContaingMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(1);
		ar.add(2);
		ar.add(4);
		ar.add(5);
		// ar.add(4);
		int c = conMostWater(ar);
		System.out.println(c);
	}

	public static int conMostWater(ArrayList<Integer> A) {
		int len = A.size();
		int low = 0;
		int high = len - 1;
		int area = 0;
		while (low < high) {
			area = Math.max(area, Math.min(A.get(low), A.get(high)) * (high - low));
			if (A.get(low) < A.get(high)) {
				low++;
			} else {
				high--;
			}
		}
		return area;
	}
}
