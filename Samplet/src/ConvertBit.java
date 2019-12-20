import java.util.Scanner;

public class ConvertBit {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int inputNo = scan.nextInt();
        for(int i=0; i< inputNo; i++){
            long num = scan.nextLong();
            convertBin(num);
        }
        scan.close();
    }
    
    public static void convertBin(long num){
        long a;
        String s="";
        while (num > 0){
           a =  num%2;
            s=a+s;
            num = num/2;
        }
        System.out.println(s);
    }
}
