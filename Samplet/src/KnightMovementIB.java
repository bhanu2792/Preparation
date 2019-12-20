import java.util.LinkedList;
import java.util.Queue;

public class KnightMovementIB {

  static class KnightPair {
    int distance;
    int x;
    int y;

    KnightPair(int d, int x, int y) {
      this.distance = d;
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] arg0) {
    int ans = knight(2-1, 20-1, 1-1, 18-1, 1-1, 5-1);
    System.out.println(ans);

  }

  public static int knight(int A, int B, int C, int D, int E, int F) {
    int ans = BFS(C, D, E, F, A, B);

    return ans;

  }

  public static boolean isValid(boolean[][] isVisit, int r, int c, int rowSize, int colSize) {
    if (r >= 0 && r <= rowSize && c >= 0 && c <= colSize && !isVisit[r][c]) {
      return true;
    }

    return false;
  }

  public static int BFS(int A, int B, int C, int D, int row, int col) {
    int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
    int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};

    Queue<KnightPair> qu = new LinkedList<KnightPair>();
    qu.add(new KnightPair(0, A, B));

    KnightPair pair;
    int xValue;
    int yValue;

    boolean[][] isVisit = new boolean[row + 1][col + 1];
    isVisit[A][B] = false;

    while (!qu.isEmpty()) {
      pair = qu.remove();

      if (pair.x == C && pair.y == D) {
           return pair.distance;
      }

      for (int i = 0; i < 8; i++) {

        xValue = pair.x + x[i];
        yValue = pair.y + y[i];
        if (isValid(isVisit, xValue, yValue, row, col)) {
            isVisit[xValue][yValue] = true;
            qu.add(new KnightPair(pair.distance + 1, xValue, yValue));
        }
      }

    }

    return -1;
  }
}
