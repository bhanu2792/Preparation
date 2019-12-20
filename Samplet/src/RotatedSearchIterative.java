import java.util.ArrayList;
import java.util.List;

public class RotatedSearchIterative {
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
	        
	     int ans = search(a, 6);
	     System.out.print(ans);
		}
	
	public static int search(final List<Integer> a, int b) {
		int low = 0; 
		int high = a.size()-1;
		int mid =0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a.get(mid) == b) {
				return mid;
			}
			
			if (a.get(mid) >= a.get(low)) {

				if (b >= a.get(low) && b <= a.get(mid)) {
					high = mid -1;
				} else {
					low = mid+1;
				}
			} else {

				if (b >= a.get(mid) && b <= a.get(high)) {
				   low = mid+1;
				} else {
					high = mid -1;
				}
			}
			
		}
		
		return -1;
    }
}
