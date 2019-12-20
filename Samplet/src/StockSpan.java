import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
        	int size = Integer.parseInt(br.readLine());
        	int[] arr = new int[size];
        	String[] inp=br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(inp[j]);
            }
            countStockSpan(arr);
        }
    }
    
    public static void countStockSpan(int[] arr) {
       Stack<Integer> st = new Stack<Integer>();
        int len = arr.length;
        int[] res = new int[len];
        res[0] = 1;
        st.push(0);
        int i = 1;
        while (i < len) {
            if (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            } else {
                if (!st.isEmpty()) {
                    res[i] = i - st.peek();
                } else {
                    res[i] = i + 1;
                }
                st.push(i);
                i++;
            }
        }

        for (int j =0; j<len; j++) {
            System.out.print(res[j]+" ");
        }
        System.out.println();
    }
}
