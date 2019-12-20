import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimplifyDirectory {

	public static Stack<String> s = new Stack<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(br.readLine());
        for (int i =0; i < inputSize; i++){
        	Stack<String> st = new Stack<String>();
        	int len = Integer.parseInt(br.readLine());
        	for (int j=0; j < len; j++) {
        		String[] cmd = br.readLine().trim().split("\\s+");
        		if (cmd[0].equals("cd")) {
        			createDirectory(cmd[1]);
        		} else {
        			printDirectory();
        		}
        	}
        	System.out.println();
        }
	}

	public static void createDirectory(String dir) {
		int len = dir.length();

		for (int i = 0; i < len; i++) {

			String st = "";

			while (i < len && dir.charAt(i) == '/') {
				i++;
			}

			while (i < len && dir.charAt(i) != '/') {
				st = st + dir.charAt(i);
				i++;
			}
			
			if (st.equals("..")) {
				if (!s.isEmpty()) {
					s.pop();
				}
			} else if (st.equals(".")) {
				continue;
			} else if (!st.isEmpty()) {
				s.push(st);
			}
		}
		
		
	}
	
	public static void printDirectory() {
		System.out.print("/");
		Object[] vals = s.toArray();
		if (!s.isEmpty()) {
			for (Object obj : vals) {
				System.out.print(obj + "/");
			}

		}
		System.out.println();
	}
}
