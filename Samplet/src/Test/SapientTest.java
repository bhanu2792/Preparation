package Test;

public class SapientTest {

  public static String compareStrings(String firstString, String secondString, String thirdString) {
    int x = firstString.compareTo(secondString);
    String a = "";
    String b = "";
    String c = "";
    if (x < 0){
        a = firstString;
        b = secondString;
    } else {
        a = secondString;
        b = firstString;
    }
    int y = b.compareTo(thirdString);
    if (y < 0){
        c = thirdString;
    } else {
         c = b;
         b = thirdString;
    }
    String ans = a+b+c;
    return ans;
}

  public static void main(String[] arg0) {
    String a= "klmno";
    String b = "abcde";
    String c = "fghij";
    String aa=  compareStrings(a, b, c);
    System.out.println(aa);
  }
}
