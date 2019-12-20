import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class BinaryAdj 
{ 
    static  int countStrings(int n) 
    { 
        int a[] = new int [n]; 
        int b[] = new int [n]; 
        a[0] = b[0] = 1; 
        for (int i = 1; i < n; i++) 
        { 
            a[i] = (a[i-1]%1000000007 + b[i-1]%1000000007) %1000000007 ; 
            b[i] = a[i-1]%1000000007 ; 
        } 
        return (a[n-1]%1000000007  + b[n-1]%1000000007 )%1000000007 ; 
    } 

    public static void main(String[] arg0) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int ans = countStrings(n);
            bw.write(ans+"\n");
        }
        br.close();
        bw.close();
    }
}