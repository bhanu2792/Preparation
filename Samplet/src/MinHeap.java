import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MinHeap {

	static int size = 0;
	static int maxSize = 1000000;
	static int[] heap = new int[maxSize];
	static int Front = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			if (inp[0].equals("insert")) {
				insert(Integer.parseInt(inp[1]));
			} else if (inp[0].equals("getMin")) {
				getMin(bw);
			} else if (inp[0].equals("delMin")) {
				delete();
			}
		}
		br.close();
		bw.close();
	}

	public static int parent(int pos) {
		return pos / 2;
	}

	public static int getLeftChild(int pos) {
		return (2 * pos);
	}

	public static int getRightChild(int pos) {
		return ((2 * pos) + 1);
	}

	public static boolean isLeaf(int pos) {
		if ((pos > (size / 2) && pos <= size) || pos > size) {
			return true;
		}
		return false;
	}

	public static void insert(int x) {
		if (size >= maxSize) {
			return;
		}

		heap[++size] = x;
		int cur = size;
		while (parent(cur) != 0 && heap[cur] < heap[parent(cur)]) {
			swap(cur, parent(cur));
			cur = parent(cur);
		}
	}

	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	public static void delete() {
		if (size > 0) {
			heap[Front] = heap[size--];
			heapify(Front);
		}
	}

	public static void getMin(BufferedWriter bw) throws IOException {
		if (size > 0) {
			bw.write(heap[1] + "\n");
		} else {
			bw.write("Empty" + "\n");
		}
	}

	public static void heapify(int cur) {

		if (!isLeaf(cur)) {
			if (heap[cur] > heap[getLeftChild(cur)] || heap[cur] > heap[getRightChild(cur)]) {

				if (heap[getLeftChild(cur)] < heap[getRightChild(cur)]) {
					swap(cur, getLeftChild(cur));
					heapify(getLeftChild(cur));
				} else {
					swap(cur, getRightChild(cur));
					heapify(getRightChild(cur));
				}
			}
		}

	}

}
