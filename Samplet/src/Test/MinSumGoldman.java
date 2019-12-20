package Test;

import java.util.List;

public class MinSumGoldman {

  static int getCountOfPossibleTeams(List<Integer> coders, int n) {
    // Initialize the answer
    int ans = 0;

    for (int i = 1; i < n - 1; ++i) {
      int one = 0;
      int two = 0;
      for (int j = 0; j < i; ++j)
        if (coders.get(j) < coders.get(i)) {
          one++;
        }
      for (int k = i + 1; k < n; ++k)
        if (coders.get(k) > coders.get(i)) {
          two++;
        }
      ans = ans + one * two;
    }

    for (int i = 1; i < n - 1; ++i) {
      int one = 0;
      int two = 0;
      for (int j = 0; j < i; ++j)
        if (coders.get(j) > coders.get(i)) {
          one++;
        }
      for (int k = i + 1; k < n; ++k)
        if (coders.get(k) < coders.get(i)) {
          two++;
        }
      ans = ans + one * two;
    }
    return ans;
  }



}
