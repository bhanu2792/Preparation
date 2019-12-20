import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class computeFact {

	static long[] arr = new long[1000000];
	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		findFact(1000000, bw);
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			fact(n, bw);
		}
		br.close();
		bw.close();
	}

	public static void findFact(int N, BufferedWriter bw) throws IOException {
		
        long ans = 1;
	    for (int i =1; i <= N; i++) {
	    	ans = (ans * i) % 1000000007;
	    	arr[i-1] = ans;
	    }
	}
	
	public static void fact(int n, BufferedWriter bw) throws IOException {
		if (n==0){
            bw.write(0+"\n");
        } else {
            bw.write(arr[n-1]+"\n");
        }
	}
}
