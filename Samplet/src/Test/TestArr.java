package Test;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArr {

  public static void main(String[] arg0) {
    // size == 4
    ArrayList<Integer> ar = new ArrayList<Integer>(2);

    ar.add(1);
    ar.add(2);
    ar.add(3);
    ar.add(4);
    ar.add(5);
    ar.add(6);

    for (int i = 0; i < ar.size(); i++) {

      if (ar.get(i) == 2 || ar.get(i) == 5) {
        ar.remove(ar.get(i));
      }

      System.out.println(ar.get(i));
    }

    Iterator<Integer> it = ar.iterator();
    while (it.hasNext()) {
      int i = it.next();
      if (i == 1 || i == 6) {
        it.remove();
      }
      System.out.println(it.next());
    }

  }

}
