import java.util.ArrayList;
import java.util.Collections;

public class tripleSumZero {

	public static void main(String[] arg0) {
        int arr[] = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
		ArrayList<Integer> ar = new ArrayList<Integer>();
	    for (int i =0; i<arr.length; i++) {
	    	ar.add(arr[i]);
	    }

		tripleSum(ar);
	}

	public static ArrayList<ArrayList<Integer>> tripleSum(ArrayList<Integer> A) {
		Collections.sort(A);
		
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         for (int i =0; i < A.size(); i++) {
        	 if (i > 0 && A.get(i).equals(A.get(i-1))) {
 				continue;
 			 }
        	 int low = i+1;
        	 int high = A.size()-1 ;
        	 
        	 while (low < high) {
        		 if (A.get(i)+A.get(low)+A.get(high) == 0) {
        			 ArrayList<Integer> temp = new ArrayList<Integer>();
        			 temp.add(A.get(i));
        			 temp.add(A.get(low));
        			 temp.add(A.get(high));
        			 result.add(temp);
        			 System.out.println(A.get(i)+ " " +A.get(low) + " " +A.get(high) + " ");
        			 low++;
        			 high--;
        			 while (low < high && A.get(low).equals(A.get(low-1))) {
        				low++; 
        			 }
        			 while (low < high && A.get(high).equals(A.get(high+1))) {
         				high--; 
         			 }
        		 } else if (A.get(i)+A.get(low)+A.get(high) < 0) {
        			 low++;
        		 } else {
        			 high--;
        		 }
        	 }
         }
         
         return result; 	
	}
}
