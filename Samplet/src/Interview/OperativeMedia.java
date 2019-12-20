package Interview;

public class OperativeMedia {

  public static int solution(int A[]) {
    int len = A.length;
    int max_count = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      int count = 1;
      if (A[i] > 0) {
        int temp = A[i];
        while (temp != i) {
          count++;
          int k = A[temp];
          A[temp] = -1;
          temp = k;
        }
        A[i] = -1;
        max_count = Math.max(max_count, count);
      }
    }

    return max_count;
  }
  public static void main(String[] args) {
    int arr[] = {5,4,0,3,1,6,2};
    System.out.println(solution(arr));
  }
}
