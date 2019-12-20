import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CollectingMango {
	public static int max = 0;
	public static void main(String[] arg0) throws NumberFormatException, IOException {
		 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputSize = Integer.parseInt(br.readLine());
        for (int i =0; i < inputSize; i++){
        	Stack<Integer> st1 = new Stack<Integer>();
        	int len = Integer.parseInt(br.readLine());
        	out.write("Case "+ (i+1) +":" + "\n");
        	for (int j=0; j <len; j++) {
        		String[] cmd = br.readLine().trim().split("\\s+");
        		if (cmd[0].equals("A")) {
        			add(st1, Integer.parseInt(cmd[1]));
        		} else if (cmd[0].equals("R")) {
        			remove(st1);
        		} else if (cmd[0].equals("Q")) {
        			if(query(st1) != -1)
        				out.write(query(st1) + "\n");
        			else 
        				out.write("Empty" + "\n");
        		}
        	}
        }
        br.close();
		out.close();
	}

	public static void add(Stack<Integer> stack, int num) {
		if(stack.isEmpty()) {
			stack.push(num);
			max = num;
		}
		else
		{
			if(max > num) {
				stack.push(num);
			}
			else {
				stack.push(max-num);
				max = num;
			}
		}
	}
	
	public static void remove(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		if(stack.peek() < 0) {
			max = max + stack.peek();
		}
		stack.pop();
	}
	
	public static int query(Stack<Integer> stack) {
		if(stack.isEmpty())
			return -1;
		return max;
	}
}
