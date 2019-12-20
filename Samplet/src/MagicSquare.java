class MagicSquare {

	// this program takes in two 2D arrays as
	// input and compares them to find out the
	// minimum number of changes that needs to
	// be made to convert arr to ms.
	public static int findMinimumFromMS(int[][] arr, int[][] ms) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] != ms[i][j])
					sum = sum + Math.abs(arr[i][j] - ms[i][j]);
			}
		}
		return sum;
	}

	public static int findMinimum(int[][] arr) {
		int[][][] ms = {
				{ { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
				{ { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
				{ { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }, 
				{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
				{ { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
				{ { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
				{ { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
				{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } },
		};

		// If all the elements need to be changed,
		// there would be 9 changes, so we take the
		// max as 9
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 1; i++) {
			int x = findMinimumFromMS(arr, ms[i]);
			System.out.println(i + " x is -> " + x);
			if (x < min)
				min = x;
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] arr = { { 4, 5, 8 }, { 2, 4, 1 }, { 1, 9, 7 } };
		System.out.println(findMinimum(arr));
	}
}
