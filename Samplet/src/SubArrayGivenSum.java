public class SubArrayGivenSum {
  static int findElement(int[] arr, int n) {
    // leftMax[i] stores maximum of arr[0..i-1]
    int[] leftMax = new int[n];
    leftMax[0] = arr[0];

    // Fill leftMax[]1..n-1]
    for (int i = 1; i < n; i++)
      leftMax[i] = Math.max(leftMax[i - 1], arr[i]);

    // Initialize minimum from right
    int[] rightMin = new int[n];
    rightMin[n-1] = arr[n-1];

    
    for (int i = n - 1; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i], arr[i-1]);
    }
    // Traverse array from right
    for (int i = n - 1; i >= 0; i--) {
      // Check if we found a required element
      if (leftMax[i] < arr[i] && rightMin[i] > arr[i])
        return i;

      // Update right minimum
    }

    // If there was no element matching criteria
    return -1;

  }

  // Driver code
  public static void main(String args[]) {
    int[] arr = {5, 1, 4, 6, 98, 8, 10, 7, 9};
    int n = arr.length;
    System.out.println("Index of the element is " + findElement(arr, n));
  }

  // This code is contributed
  // by rachana soma
}
