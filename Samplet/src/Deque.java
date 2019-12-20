import java.util.Scanner;

public class Deque {

	static int size = 10000;
	static int arr[] = new int[10000];
	static int front = -1;
	static int rear = -1;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.nextLine();
		String s1 = "";
		for (int i = 0; i < input; i++) {
			s1 = scan.nextLine();
			String[] sub = s1.split(" ");

			switch (sub[0]) {
			case "push_front":
				push_front(Integer.parseInt(sub[1]));
				break;
			case "push_back":
				push_back(Integer.parseInt(sub[1]));
				break;
			case "pop_back":
				pop_back();
				break;
			case "pop_front":
				pop_front();
				break;

			default:
				break;
			}
		}

	}

	public static void push_front(int val) {
		if (count < size) {

			if (front < 0) {
				front = size + front;
			}

			arr[front] = val;
			count++;

			front = (front - 1);

		}
	}

	public static void push_back(int val) {
		if (count < size) {
			rear = (rear + 1) % size;
			arr[rear] = val;
			count++;
		} else {
			System.out.println("Full");
		}
	}

	public static void pop_front() {
		if (count > 0) {
			front = (++front) % size;
			System.out.println(arr[front]);
			arr[front] = 0;
			count--;
		} else {
			System.out.println("Empty");
		}

	}

	public static void pop_back() {
		if (count > 0) {

			if (rear < 0) {
				rear = size + rear;
			}

			System.out.println(arr[rear]);
			arr[rear] = 0;
			count--;

			rear = (rear - 1);
		} else {
			System.out.println("Empty");
		}
	}

}
