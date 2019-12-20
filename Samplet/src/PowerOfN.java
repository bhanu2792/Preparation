
public class PowerOfN {

  public static void main(String[] arg0) {

    long ans = powerOfN(5, 12);
    System.out.println("Ans is " + ans);
  }

  public static long powerOfN(int a, int n) {
    int ans = 1;
    int x = a;
    while (n != 0) {
      if (n % 2 == 1) {
        ans = ans * x;
      }
      x = x * x;
      n = n >> 1;
    }
    return ans;
  }

}
