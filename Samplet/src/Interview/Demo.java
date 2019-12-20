package Interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

abstract class Arithmetic {

  public abstract long add(int a, int b);

}

class Adder extends Arithmetic {

  @Override
  public long add(int a, int b) {
    // TODO Auto-generated method stub
    return a + b;
  }

}

public class Demo {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    scan.close();
    
Adder adderObject = new Adder();
    
System.out.println(adderObject.getClass().getSuperclass().getName()); 
System.out.print(adderObject.add(a, b));
}
  class meeting { 
    int start; 
    int end; 
    int pos; 
}; 
  public static int countMeetings(List<Integer> arrival, List<Integer> departure) {
   
    int i, j; 
    
    i = 0; 
    int count =0;
       int n = arrival.size();
    for (j = 1; j < n; j++) 
    { 
         // If this activity has start time greater than or 
         // equal to the finish time of previously selected 
         // activity, then select it 
         if (arrival.get(j) >= departure.get(i)) 
         { 
             count++;
              i = j; 
          } 
     } 
    return count;
    }
}
