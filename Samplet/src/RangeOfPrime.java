import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RangeOfPrime {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inputSize = Integer.parseInt(br.readLine());
		int[] preComArr = primeComArr(1000000);
		for (int i = 0; i < inputSize; i++) {
			String[] s = br.readLine().split("\\s+");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int ans = primeCount(preComArr, a, b);
			bw.write(ans+"\n");
		}
		br.close();
		bw.close();
	}

	public static int primeCount(int[] preComArr, int a, int b) {
		int count = 0;
		if (a > 0) {
			a= a-1;
		}		
		count = preComArr[b]-preComArr[a];
		return count;
	}

	public static int[] primeComArr(int N) {
		boolean[] arr = new boolean[N + 1];
		int[] countArr = new int[N + 1];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (arr[i] == false) {
				long j = i*i;
				while(j > 0 && j < 1000001) {
					if (arr[(int)j] == false) {
						arr[(int)j] = true;
					}
					j = j+i;
				}
			}
		}
		int count = 0;
		for (int i = 0; i <= N; i++) {
			if (arr[i] == false) {
				countArr[i] = ++count;
			} else {
				countArr[i] = count;
			}
		}
		
		return countArr;
	}

}
