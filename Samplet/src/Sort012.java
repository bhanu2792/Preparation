import java.util.ArrayList;

public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<Integer> ar = new ArrayList<Integer>();
       ar.add(0);
       ar.add(0);
       ar.add(0);
       ar.add(0);
       ar.add(0);
       ar.add(0);
       ar.add(2);
       ar.add(1);
       
       sortFun(ar);
	}

	public static void sortFun(ArrayList<Integer> arr) {
		int high = arr.size()-1;
		int low = 0;
		int mid = 0;
		
		while (mid <= high) {
			
			switch (arr.get(mid)) {
			case 0:
				int temp = arr.get(mid);
				arr.set(mid, arr.get(low));
				arr.set(low, temp);
				mid++;
				low++;
				break;

			case 1:
				mid++;
				break;
			case 2:
				int temp1 = arr.get(mid);
				arr.set(mid, arr.get(high));
				arr.set(high, temp1);
				high--;
				break;
			default:
				break;			
			}
		}
		
		
		  for (Integer a : arr) { System.out.print(a + " "); }
		 
		
		
	}
}
