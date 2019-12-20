import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ContestQue3 {

	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			int size = Integer.parseInt(inp[0]);
			int range = Integer.parseInt(inp[1]);
			int[] arr = new int[size];
			inp = br.readLine().split("\\s+");
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(inp[i]);
			}
			int countArray[] = new int[range + 1];
			for (int i : arr) {
				countArray[i]++;
			}
			int sum = 0;
			for (int i = 0; i < range + 1; i++) {
				sum = sum + countArray[i];
				countArray[i] = sum;
			}

			int Query = Integer.parseInt(br.readLine());
			for (int j = 0; j < Query; j++) {
				inp = br.readLine().split("\\s+");
				int a = Integer.parseInt(inp[0]);
				int b = Integer.parseInt(inp[1]);
				a = a == 0 ? a : a - 1;
				int ans = countArray[b] - countArray[a];
				bw.write(ans + "\n");
			}
		}
		br.close();
		bw.close();
	}
}
