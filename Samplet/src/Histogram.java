import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Histogram {

	public static void main(String[] args) throws IOException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		for (int i = 0; i < input; i++) {
			int size = Integer.parseInt(br.readLine());
			Integer[] arr = new Integer[size];
			String[] inp = br.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				arr[j] = Integer.parseInt(inp[j]);
			}
			ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
			int ans = maxArea(arrayList);
			System.out.println(ans);
		}
	}

	public static int maxArea(ArrayList<Integer> A) {
		Stack<Integer> st = new Stack<Integer>();
		int len = A.size();
		int top;
		int area = 0;
		int max_area = 0;
		int i = 0;
		while (i < len) {
			if (st.isEmpty() || A.get(st.peek()) <= A.get(i)) {
				st.push(i++);
			} else {

				top = st.peek();
				st.pop();

				area = A.get(top) * (st.empty() ? i : i - st.peek() - 1);

				if (area > max_area) {
					max_area = area;
				}
			}
		}

		while (!st.isEmpty()) {
			top = st.peek();
			st.pop();

			area = A.get(top) * (st.empty() ? i : i - st.peek() - 1);

			if (area > max_area) {
				max_area = area;
			}
		}

		return max_area;

	}
}