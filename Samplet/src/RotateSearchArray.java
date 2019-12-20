import java.util.ArrayList;

public class RotateSearchArray {

	public static void main(String[] arg0) {
	//	4 5 6 7 0 1 2
    ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(0);
        a.add(1);
        a.add(2);
        
     int ans = searchArray(a, 0, 6, 2);
     System.out.print(ans);
	}

	public static int searchArray(ArrayList<Integer> a, int low, int high, int b) {
		
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;

		if (a.get(mid) == b) {
			return mid;
		}

		if (a.get(mid) >= a.get(low)) {

			if (b >= a.get(low) && b <= a.get(mid)) {
				return searchArray(a, low, mid - 1, b);
			}

			return searchArray(a, mid + 1, high, b);

		} else {

			if (b >= a.get(mid) && b <= a.get(high)) {
			    return searchArray(a, mid + 1, high, b);
			}

			return searchArray(a, low, mid - 1, b);
		}

	}
}
