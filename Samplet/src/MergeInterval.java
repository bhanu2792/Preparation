
// Java program to merge overlapping Intervals in 
// O(n Log n) time and O(1) extra space. 
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	public static void mergeIntervals(Interval arr[]) {
		// Sort Intervals in decreasing order of
		// start time
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int index = 0; // Stores index of last element
		// in output array (modified arr[])

		// Traverse all input Intervals
		for (int i = 1; i < arr.length; i++) {
			// If this is not first Interval and overlaps
			// with the previous one
			if (arr[index].end >= arr[i].start) {
				
					arr[index].end = Math.max(arr[index].end, arr[i].end);
					arr[index].start = Math.min(arr[index].start, arr[i].start);
					
				}
			else {
				arr[index].start = arr[i].start;
				arr[index].end = arr[i].end;
			}
			index++;
			} 
		

		System.out.print("The Merged Intervals are: ");
		for (int i = 0; i < index; i++)
			System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
		
	}

	public static void main(String args[]) {
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(1, 3);
		arr[1] = new Interval(2, 6);
		arr[2] = new Interval(8, 10);
		arr[3] = new Interval(15, 18);
		mergeIntervals(arr);
	}
}

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
// This code is contributed by Gaurav Tiwari
