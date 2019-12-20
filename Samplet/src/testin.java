import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testin {

	
	
	public static void main (String[] arg0) throws IOException {
		
		 InputStreamReader r=new InputStreamReader(System.in);    
	     BufferedReader br=new BufferedReader(r);
	     int size = br.read();
	     int [] arr = new int[size];
	     for (int i=0; i<size; i++) {
	    	 arr[i] = br.read();
	     }
	     int size2 = br.read();
	   //  int [] arr2 = new int[size2];
	     for (int k =0; k<size2; k++){
	    	   int val = br.read();
	    	   //findFreq(arr, val);
	     }
	}
}
