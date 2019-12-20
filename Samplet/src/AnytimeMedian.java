import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class AnytimeMedian {

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
			findMedian(ar, len, bw);
		}
		br.close();
		bw.close();
	}

	public static void findMedian(int[] arr, int len, BufferedWriter bw) throws IOException {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		maxHeap.add(arr[0]);
		bw.write(arr[0]+" ");
		
		if (len < 2) {
			return;
		}
		for (int i = 1; i < len; i++) {
			int x = arr[i];
			if (x < maxHeap.peek()) {
				maxHeap.add(x);
			} else {
				minHeap.add(x);
			}

			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.remove());
			} else if (minHeap.size() - maxHeap.size() > 0) {
				maxHeap.add(minHeap.remove());
			}

			bw.write(maxHeap.peek()+ " ");

		}
		bw.newLine();

	}

}
