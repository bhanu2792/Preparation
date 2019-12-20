import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeFear {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * int[] preComArr = primeFear(1000000); primeCount(preComArr,1000000);
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int inputSize = Integer.parseInt(br.readLine());
        int[] preComArr = primeFear(1000000);
        for (int i =0; i < inputSize; i++){
            int num = Integer.parseInt(br.readLine());
           int ans = primeCount(preComArr,num);
           bw.write(ans);
        }
        bw.flush();
	}

	public static int primeCount(int[] preComArr, int num) {
		return preComArr[num];
	}
	
	public static int[] primeFear(int N) {
		boolean[] arr = new boolean[N + 1];
		int[] preCom = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			arr[i] = true;
		}
		arr[0] = false;
		arr[1] = false;
		int count = 0;
		for (int i = 2; i <= Math.sqrt(N); i++) {
			for (int j = i * i; j <= N; j = j + i) {
				arr[j] = false;
			}
		}
		
		for (int i = 0; i <= N; i++) {

			if (arr[i] == true && isFear(arr, i)) {
				preCom[i] = ++count;
			} else {
				preCom[i] = count;
			}
		}
		return preCom;
	}

	public static boolean isFear(boolean[] primeArr, int num) {
		int a = 1;
		int div = 0;
		int cur = 0;
		int rem = 0;
		if (num < 10) {
			return true;
		}
		while (num > 10) {
			div = num / 10;
			rem = num % 10;
			if (rem == 0) {
				return false;
			}
			cur = cur + (rem*a);
			num = div;
			a = a * 10;
			if (primeArr[cur] == false ) {
				return false;
			}
		}
		return true;
	}

}
