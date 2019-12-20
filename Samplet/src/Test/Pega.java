package Test;

public class Pega {

  public static void func (int n) {
    long sum = 1;
    
    
    
    long ans = (long) Math.sqrt(sum);
    if (sum < n) {
      System.out.println(ans + " " + (ans+1));
    } else {
      System.out.println(ans + " " + ans);
    }
    
    
    
    
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    func(28);
  }

}
