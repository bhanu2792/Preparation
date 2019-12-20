import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SquareFun {
	static boolean[] ar1 = new boolean[1000000000];
	static boolean[] ar2 = new boolean[1000000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		preCompute(ar1,ar2);
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split("\\s+");;
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);
			count(a, b);
		}

		bw.flush();

	}
	
	public static void count(long a, long b) {
		long i;
		long j;
		int count = 0;
		if (a > 1000000000 && b > 1000000000) {
			 i = 1000000000-a-1;
			 j = 1000000000-b-1;
			 
			 while (i <= j) {
				 if (ar2[(int)i] == true) {
					 count++;
				 }
				 i++;
			 }
		} else if (a < 1000000000 && b > 1000000000) {
			 i = a-1;
			 j = 1000000000-1;
			 while (i <= j) {
				 if (ar1[(int)i] == true) {
					 count++;
				 }
				 i++;
			 }
			 i = 0;
			 j = b-1;
			 while (i <= j) {
				 if (ar2[(int)i] == true) {
					 count++;
				 }
				 i++;
			 }
			
		} else if (a < 1000000000 && b < 1000000000) {
			i = a-1;
			j = b-1;
			 
			 while (i <= j) {
				 if (ar1[(int)i] == true) {
					 count++;
				 }
				 i++;
			 }
		}
		
		System.out.println(count);
	}

	public static void preCompute(boolean[] ar1, boolean[] ar2) {
		long p = 1;
		int sqr = (int) Math.sqrt(1000000000);
		for (int i = 0; i <= sqr; i++) {
			 p = i * i;
             if (p > 0 && p <= 1000000000) {
            	 ar1[(int)p-1] = true;
             } else if (p > 1000000000 && p <= Math.pow(10, 1000000000)) {
            	 ar2[(int)p-1000000000-1] = true;
             }
		}
	}
}
