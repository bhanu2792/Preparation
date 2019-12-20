import java.util.ArrayList;

public class diffK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(2);
		al.add(3);
		al.add(5);
		al.add(20);
		al.add(50);
		al.add(80);
		String s = diffK(al, 0);
		System.out.println(s);
	}

	public static String diffK(ArrayList<Integer> ar, int k) {

		int low = 0;
		int high = 1;
		int n = ar.size();
		while (low < n && high < n) {

			if (low != high && ar.get(high) - ar.get(low) == k) {
				return "Yes";
			} else if (ar.get(high) - ar.get(low) > k) {
				low++;
			} else {
				high++;
			}

		}
		return "No";
	}

}
