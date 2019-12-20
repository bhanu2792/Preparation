import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimplifyPathInterviewBit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * inputSize = Integer.parseInt(br.readLine()); for (int i =0; i < inputSize;
		 * i++){ Stack<String> st = new Stack<String>(); int len =
		 * Integer.parseInt(br.readLine()); for (int j=0; j < len; j++) { String[] cmd =
		 * br.readLine().trim().split("\\s+"); if (cmd[0].equals("cd")) {
		 * createDirectory(cmd[1]); } else { printDirectory(); } } System.out.println();
		 * }
		 */

		String s = createDirectory("/bg/../vs");
		System.out.println(s);
	}

	public static String createDirectory(String A) {
		Stack<String> stack = new Stack<String>();
        String[] args = A.trim().split("/");
        for (String s : args) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if(!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
			sb.insert(0, "/");
        }
        
        return sb.length() != 0 ? sb.toString() : "/";
	}

	/*
	 * public static void printDirectory() { System.out.print("/"); Object[] vals =
	 * s.toArray(); if (!s.isEmpty()) { for (Object obj : vals) {
	 * System.out.print(obj + "/"); }
	 * 
	 * } System.out.println(); }
	 */
}
