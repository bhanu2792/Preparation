import java.util.ArrayList;
import java.util.Collections;

public class medianTwoArray {
	public static void main(String[] arg0) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(0);
		a.add(1);
		a.add(2);
        int c = binarySearch1(a, 7, 3);
        System.out.print(c);
	}

	public static int binarySearch1(ArrayList<Integer> arr, int size, int k) {
        Collections.sort(arr);
		int low = 0;
		int high = size;
		int mid = 0;
		int count = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (arr.get(mid) > k) {
				high = mid - 1;
			} else {
				
				low = mid + 1;
			}
		}

		return low-1;
	}

}
