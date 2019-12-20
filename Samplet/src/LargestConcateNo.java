import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestConcateNo {

	public static void main(String[] arg0) {
		
		
		
		
		
	}
	
	
	public static void findLargestConNum(ArrayList<String> arr, int size) {
		
      List<String> newList = arr.stream().map(String::valueOf).collect(Collectors.toList());
        
      Collections.sort(arr, new Comparator<String>() {

		@Override
		public int compare(String x, String y) {
			// TODO Auto-generated method stub
			String ab = x+y;
			String ba = y+x;
			
			return ab.compareTo(ba) > 0 ? -1:1;
		}  
	});
		
		
		
	}
	

	
}
