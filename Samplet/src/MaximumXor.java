import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class MaximumXor {

	public static void main(String[] arg0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];
			String[] inp = br.readLine().split("\\s+");
			for (int i = 0; i < len; i++) {
				ar[i] = Integer.parseInt(inp[i]);
			}
			minXor(ar, len, bw);
		}
		br.close();
		bw.close();
	}

	public static void minXor(int[] nums, int n, BufferedWriter bw) throws IOException {
		int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        bw.write(max+ "\n");
	}
}
