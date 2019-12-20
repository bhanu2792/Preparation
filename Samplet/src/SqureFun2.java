import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SqureFun2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split("\\s+");
			;
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);
			count(a, b, bw);
		}

		br.close();
		bw.close();

	}

	public static void count(long a, long b, BufferedWriter bw) throws IOException {
		long sqr1 = (long) Math.ceil(Math.sqrt(a));
		long sqr2 = (long) Math.floor(Math.sqrt(b));

		long diff = sqr2 - sqr1 + 1;

		if (diff >= 0)
			bw.write(diff + "\n");
		else
			bw.write(0 + "\n");
	}
}
