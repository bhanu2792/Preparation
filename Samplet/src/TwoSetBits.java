
public class TwoSetBits {
 
	public static void main (String[] arg0) {
		
	twoSetBit(3);
		
	//3, 5, 6, 9, 10, 12, 17, 18, 20
		
	}
	
	public static void twoSetBit(int N) {
		
		int n = -2*N;
		double x = (1+ Math.sqrt(1-4*n))/2;
		double y = (1- Math.sqrt(1-4*n))/2;
		int z;
		
		System.out.println("x is ->" +x + "y is" + y);
		if (x > y && y > 0) {
			z= (int) Math.floor(y);
		} else {
			z = (int) Math.floor(x);
		}
		System.out.println("val is ->" +z);
		int val2= ((z-1)*(z));
		System.out.println("val2 is ->" +val2);
		int val3;
		
        val3 = N-val2;
		
		
		System.out.println("val3 is ->" +val3);
		int ans = (int) (Math.pow(2, z) + Math.pow(2,val3-1));
		System.out.println(ans);
	}
	
}
