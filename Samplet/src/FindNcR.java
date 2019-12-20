import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class FindNcR {

	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			int n = Integer.parseInt(inp[0]);
			int r = Integer.parseInt(inp[1]);
			nCrModp(n, r, 1000000007, bw);
		}
		br.close();
		bw.close();
	}

	 public static void nCrModp(int n, int r, int p, BufferedWriter bw) throws IOException {
	        int C[] = new int[r + 1];
	        C[0] = 1;
	        for (int i = 1; i <= n; i++) {
	            for (int j = Math.min(i, r); j > 0; j--)
	                C[j] = (C[j]% p + C[j - 1]% p) % p;
	        }
	        bw.write(C[r] + "\n");
	    }
}
