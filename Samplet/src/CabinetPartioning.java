
public class CabinetPartioning {

	public static void main (String[] arg0) {
		int[] arr = {1,1};
		partioningCabinet(arr,3);
	}
	
	public static int getMax(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int getSum(int[] arr, int n) {
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum = sum+arr[i];
		}
		return sum;
	}
	
	public static int getPartion(int[] arr, int n, int k) {
		int count = 1;
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum = sum + arr[i];
			if (sum > k) {
				sum = arr[i];
				count++;
			}
		}
		return count;
	}
	
	public static void partioningCabinet(int[] arr, int k) {
		int n = arr.length;
		int low = getMax(arr,n);
		int high = getSum(arr,n);
		int mid =0;
		while (low < high) {
			mid = (low+high)/2;
			int noOfPartion = getPartion(arr, n, mid);
			if (noOfPartion <= k ) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		System.out.print(low);
	}
}
