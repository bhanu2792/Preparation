import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aakash {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            int[] ar = new int[len];

            String[] ints = br.readLine().trim().split("\\s+");
            
            int last = 1;
            long total = 0;
            long subTotal = 0;
            int last2 = 0;
            int idx1= 0;
            int idx2= 0;
            for (int p = 0; p < len; p++) {
                ar[p] = Integer.parseInt(ints[p]);
                
                if(ar[p] >= last) {
                    total += subTotal;
                    last = ar[p];
                    last2 = 0;
                    subTotal = 0;
                    idx1 = p;
                }
                else {
                    
                    if(ar[p]>=last2) {
                        last2 = ar[p];
                        idx2 = p;
                    }
                    subTotal += last-ar[p];
                }
            }
            
            
            for(int i=idx1 + 1;i< idx2;i++) {
                total += (last2-ar[i]);
            }

            System.out.println(total);
            
        }
    }

}
