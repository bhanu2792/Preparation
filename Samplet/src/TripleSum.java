import java.util.ArrayList;
import java.util.Collections;

public class TripleSum {

	public static void main (String[] arg0) {
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		ar.add(1);
		ar.add(1);
		ar.add(1);
		//ar.add(-4);
		
		int i = nTriang(ar);
 		System.out.print(i);
	}
	
    public static int nTriang(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int count =0;
        if (n < 3) return count;
        for (int i=n-1; i >= 0; i--){
             int j = 0;
             int k=i-1;
             while (j<k) {
             long total = A.get(j)+A.get(k);
              if (total > A.get(i)){
                    k--;
                    count = (count + (k-j)%1000000007)%1000000007;
               } else {
                   j++;
               }
            }
        }
        return count;
    }
	
}
