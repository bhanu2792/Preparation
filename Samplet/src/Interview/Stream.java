package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

  public static void main(String[] arg0) {
    
    ArrayList<String> ar = new ArrayList<String>();
    ar.add("Bhanu");
    ar.add("Prakash");
    ar.add("Gupta");
    ar.add("Testing");
    ar.add("TesGing");
    ar.add("gesting");
    
    ArrayList<String> ar1 = new ArrayList<String>();
    ar1.add("fdsaff");
    ar1.add("fas");
    ar1.add("fa");
    ar1.add("fa");
    ar1.add("fa");
    ar1.add("gesting");
    
    List<String> st = ar.stream().filter(s -> s.equals("fdas")).collect(Collectors.toList());
    
    for (String s : st) {
      System.out.println(s);
    }
    
  }
  
}
