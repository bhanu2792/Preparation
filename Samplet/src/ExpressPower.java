import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExpressPower {

	static boolean[] arr = new boolean[100000001];

	public static void main(String[] arg0) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		aPowerb(100000000);
		for (int t = 0; t < T; t++) {
			int A = Integer.parseInt(br.readLine());
			boolean b = isApowerB(A);
			if (b) {
				bw.write("Yes");
				bw.newLine();
			} else {
				bw.write("No");
				bw.newLine();
			}
		}

		bw.flush();
	}

	public static void aPowerb(int N) {
		long p = 1;
		int sqr = (int) Math.sqrt(N);
		for (int i = 2; i <= sqr; i++) {
			p = i * i;
			while (p > 0 && p <= N) {
				if (arr[(int)p] == false) {
					arr[(int)p] = true;
				}
				p = p * i;
			}
		}
	}

	public static boolean isApowerB(int no) {
		return arr[no];
	}
}