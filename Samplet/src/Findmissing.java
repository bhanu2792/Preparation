import java.util.Scanner;

public class Findmissing {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner scan = new Scanner(System.in);
        int inputNo = scan.nextInt();
        for(int i=0; i< inputNo; i++){
            int num = scan.nextInt();
            reverseBit(num);
        }
    }
    
    public static void reverseBit(int num){
        long rev = 0;
        while (num > 0){
             rev= rev<<1;
             if ((num&1) == 1){
                 rev= (rev^1);
        }
             num=(num>>1);
        }
        System.out.println(rev);
    }
}
