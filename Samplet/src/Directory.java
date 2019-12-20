import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Directory {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		/*
		 * changeDirectory("/sem/networks/labs/", st); printDirectory(st);
		 * changeDirectory("../../os/labs/../slides/", st); printDirectory(st);
		 * changeDirectory("/", st); printDirectory(st);
		 */
		/*
		 * changeDirectory("os/labs/", st); printDirectory(st);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputSize = Integer.parseInt(br.readLine());
		for (int i = 0; i < inputSize; i++) {
			Stack<String> st = new Stack<String>();
			int len = Integer.parseInt(br.readLine());
			for (int j = 0; j < len; j++) {
				String[] cmd = br.readLine().trim().split("\\s+");
				if (cmd[0].equals("cd")) {
					changeDirectory(cmd[1], st);
				} else {
					printDirectory(st);
				}
			}
			System.out.println();
		}
	}

	public static void changeDirectory(String dir, Stack<String> st) {
		if (dir.length() == 1 && dir.charAt(0) == '/') {
			st.clear();
		}
		String[] s = dir.split("/");
		int len = s.length;
		if (len == 0) {
			return;
		}
		int i = 0;
		if (s[0].isEmpty()) {
			i = 1;
		}

		while (!st.isEmpty() && i < len && s[i].equals("..")) {
			st.pop();
			i++;
		}
		int j = i;
		int k = 0;
		Object[] vals = st.toArray();
		if (!st.isEmpty()) {
			while (j < len && k < vals.length) {
				if (vals[k].equals(s[j])) {
					j++;
				} else {
					k++;
				}

			}
		}
		while (j > i) {
			st.clear();
			if (!s[i].equals(".") && !s[i].isEmpty()) {
				st.push(s[i]);
				i++;
			}

		}
		while (i < s.length) {
			if (s[i].equals("..")) {
				if (!st.isEmpty()) {
					st.pop();
				}
			} else {
				if (!s[i].equals(".") && !s[i].isEmpty()) {
					st.push(s[i]);
				}
			}
			i++;
		}
	}

	public static void printDirectory(Stack<String> st) {
		System.out.print("/");
		Object[] vals = st.toArray();
		if (!st.isEmpty()) {
			for (Object obj : vals) {
				System.out.print(obj + "/");
			}

		}
		System.out.println();
	}
}
