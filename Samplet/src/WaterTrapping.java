import java.util.ArrayList;

public class WaterTrapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(0);
		ar.add(0);
		ar.add(2);
		ar.add(0);
		ar.add(4);
		int c = calculateWater(ar);
		System.out.println(c);
	}

	public static int calculateWater(ArrayList<Integer> A) {
		int len = A.size();
		int rightMax = 0;
		int leftMax = 0;
		int p1 = 0;
		int p2 = len - 1;
		int count = 0;
		while (p1 <= p2) {
			if (A.get(p1) < A.get(p2)) {
				if (A.get(p1) > leftMax) {
					leftMax = A.get(p1);
				} else {
					count = count + 2 * (leftMax - A.get(p1));
				}
				p1++;
			} else {
				if (A.get(p2) > rightMax) {
					rightMax = A.get(p2);
				} else {
					count = count + 2 * (rightMax - A.get(p2));
				}
				p2--;
			}
		}
		return count;
	}

}
