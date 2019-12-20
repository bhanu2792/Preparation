package Test;

import java.util.ArrayList;
import java.util.List;

public class que2 {

  public static void finalPrice(List<Integer> prices) {
    int len = prices.size();
    long sum = 0;
    StringBuffer sb = new StringBuffer();
    boolean flag = false;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (prices.get(i) >= prices.get(j)) {
          sum = sum + (prices.get(i) - prices.get(j));
          flag = true;
          break;
        }
      }
      if (flag) {
        flag = false;
      } else {
        sum = sum + prices.get(i);
        sb.append(i + " ");
      }
    }

    sum = sum + prices.get(len - 1);
    sb.append(len - 1);
    System.out.println(sum);
    System.out.println(sb.toString());
  }

  public static void main(String[] arg0) {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(1);
    arr.add(3);
    arr.add(3);
    arr.add(2);
    arr.add(5);

    finalPrice(arr);
  }
}
