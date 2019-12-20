import java.util.Scanner;

public class PrintTriangle {
    
    public static void printTriangle(int val, int caseNo){
        System.out.println("Case #" + caseNo + ":");
        int count = val-1;
        for (int i =0; i< val; i++){
            for (int j=0; j< val; j++){
                if (j >= count){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            count--;
        }
    }

    public static void main(String[] args) {
        int caseNo =1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i < n ; i++) {

            int val = scanner.nextInt();
            printTriangle(val,caseNo++);

        }
        scanner.close();
    }
}
