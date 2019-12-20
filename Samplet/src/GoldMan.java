import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class GoldMan {

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {

        if (pattern == null || pattern.equals("")){
            return -1;
        }
        // result store output string 
        String result = ""; 

       Stack<Integer> stk = new Stack<Integer>();

        // run n+1 times where n is length of input sequence 
        for (int i = 0; i <= pattern.length(); i++) { 
            // push number i+1 into the stack 
            stk.push(i + 1); 

            if (i == pattern.length() || pattern.charAt(i) == 'N') { 
                // run till stack is empty 
                while (!stk.empty()) { 
                    // remove top element from the stack and 
                    // add it to solution 
                    result += String.valueOf(stk.peek()); 
                    stk.pop(); 
                } 
            } 
        } 

        return Integer.parseInt(result); 
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        String pattern;
        try {
            pattern = in.nextLine();
        } catch (Exception e) {
            pattern = null;
        }

        res = findPossibleSmallestNumberMatchingPattern(pattern);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
