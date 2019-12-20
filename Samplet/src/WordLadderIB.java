import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderIB {

  public static void main(String[] arg0) {
    ArrayList<String> ar = new ArrayList<String>();
    ar.add("bb");
    ar.add("ab");
  //  ar.add("dog");
   // ar.add("lot");
   // ar.add("cog");
   // ar.add("PLIE");
   // ar.add("POIN");
    String start = "";
    String target = "";
    int ans = ladderLength(start, target, ar);
    System.out.println(ans);
  }

  public static int ladderLength(String start, String end, ArrayList<String> dictV) {
    Set<String> st = new HashSet<String>();
    Queue<String> qu = new LinkedList<String>();
    qu.add(start);
    st.add(start);

    while (!qu.isEmpty()) {
      String a = qu.remove();
      if (a.equals(end)) {
        return st.size();
      }
      if (isAdjacent(a, end)){
           return st.size()+1;
      }
      for (String s : dictV) {
        if (isAdjacent(a, s) && !st.contains(s)) {
          qu.add(s);
          st.add(s);
        }
      }
    }

    return 0;
  }

  public static boolean isAdjacent(String a, String b) {
    int count = 0;
    int i = 0;
    if (a.length() != b.length()) {
      return false;
    }
    while (a.length() > i && b.length() > i) {
      if (a.charAt(i) != b.charAt(i)) {
        count++;
      }
      i++;
    }
    if (count == 1) {
      return true;
    }

    return false;
  }
}
