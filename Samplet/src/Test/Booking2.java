package Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Booking2 {

  
  public static void main (String[] arg0) {
    System.out.println(multiple(3, 5, 10, 12));
  }
  
  public static List<Integer> multiple(int x, int y, int z, int n) {
    // Write your code here
     List<Integer> ls = new ArrayList<Integer>();
     Set<Integer> s = new LinkedHashSet<Integer>();
     int i = 1;
     int num1 = x;
     int num2 = y;
     int m = x;
     int p = y;
     while(m <= n && p <= n ) {
           int a = num1*i;
           m = a;
           if (a%z != 0 && a <= n) {
               s.add(a);
           }
           int b = num2*i;
           p = b;
           if (b%z != 0 && b <= n) {
             s.add(b);
           }
           i++;
     }
     while (m <= n) {
       int a = num1*i;
       m = a;
       if (a%z != 0 && a <= n) {
           s.add(a);
       }
       i++;
     }
     while (p <= n) {
       int b = num2*i;
       p = b;
       if (b%z != 0 &&  b <= n) {
         s.add(b);
       }
       i++;
     }
     ls.addAll(s);
     return ls ;
    }
}
