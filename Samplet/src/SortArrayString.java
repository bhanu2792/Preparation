import java.util.Arrays;
import java.util.Comparator;

public class SortArrayString {

  public static void main(String[] arg0) {
    String[] s = {"sort", "string", "array"};
    Arrays.sort(s, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.compareTo(s2);
      }
    });
    System.out.println(Arrays.toString(s));
  }
}
