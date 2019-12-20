
public class CubeRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cubeRoot(-27);
	}

    public static void cubeRoot(long num){
        long newNum = Math.abs(num);
        long low =1;
        long high = newNum/2;
        long mid = 0;
        boolean isFound = false;
       
        while (low <= high){
            mid = (low+high)/2;
            long div = ((newNum/mid)/mid);
            if (mid == div){
                isFound = true;
                break;
            } else if (mid < div){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (isFound == true){
            if (num < 0)
                System.out.println(-mid);
            else 
                System.out.println(mid);
        }
    }
}
