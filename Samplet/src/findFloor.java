import java.util.Arrays;

public class findFloor {
    public static void main(String[] arr) {
    	int[] a = {-6, -100000000, -1, 20, 15, 5 };
    	
    	findFloor(a,-100000000);
    }
	
    public static void findFloor(int[] arr, int x){
        Arrays.sort(arr);
        int ans = Integer.MIN_VALUE;
        int low =0;
        int high = arr.length-1;
        int mid=0;
        while (low<=high){
            mid = (low+high)/2;
            if (x < arr[mid]){
                high = mid-1;
            } else {
                ans = arr[mid];
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
}
