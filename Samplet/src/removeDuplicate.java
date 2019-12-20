import java.util.ArrayList;
import java.util.List;

public class removeDuplicate {

	public static void main(String[] arg0) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(1);
		ar.add(2);
		ar.add(3);

		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ar1.add(1);
		ar1.add(1);
		ar1.add(2);
		ar1.add(4);

		/*
		 * ArrayList<Integer> val = intersect(ar, ar1); for (Integer i : val) {
		 * System.out.println(i); }
		 */
		
		int ans = sqrt(740819855);
		System.out.println(ans);

	}

	   public static int sqrt(int a) {
		   
		        if (a == 0){
		            return 0;
		        }
		        if (a < 4){
		            return 1;
		        }
		        long high = (a/2) + 1;
		        long low = 0;
		        long mid =0;
		        while (low < high){
		            mid = (low+high)/2;
		            if (mid*mid == a){
		                return (int)mid;
		            } else if (mid*mid < a) {
		                low = mid+1;
		            } else {
		                high = mid-1;
		            }
		        }
		        return (int)mid;
	    }

	
}
