import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class FareWell {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			ArrayList<Integer> Arrival = new ArrayList<Integer>();
			ArrayList<Integer> Dep = new ArrayList<Integer>();
			int len = Integer.parseInt(br.readLine());
			for (int i = 0; i < len; i++) {
				String[] inp = br.readLine().split("\\s+");
				Arrival.add(Integer.parseInt(inp[0]));
				Dep.add(Integer.parseInt(inp[1]));
			}
			int ans = noOfRoom(Arrival, Dep);
			bw.write(ans + "\n");
		}
		br.close();
		bw.close();
	}

	public static int noOfRoom(ArrayList<Integer> A, ArrayList<Integer> B) {
		Collections.sort(A);
		Collections.sort(B);
		int len = A.size();
		int p1 = 1;
		int p2 = 0;
		int count = 1;
		int max = 1;
		while (p1 < len && p2 < len) {
			if (A.get(p1) <= B.get(p2)) {
				count++;
				p1++;
				max = Math.max(count, max);
			} else {
				count--;
				p2++;
			}
		}
		return max;
	}
}
