
public class ReverseStringWord {

	public static void main(String[] arg0) {
		reverse("my Name is Bhanu");
	}
	
	public static String reverse(String a) {
		String[] str = a.split(" ");
		int high = str.length-1;
		int len = str.length;
		int low =0;
		String temp;
		while (low < high) {
			temp = str[high];
			str[high] = str[low];
			str[low] = temp;
			low++;
			high--;
		}
		StringBuffer sb = new StringBuffer();
		for (int i =0; i < len; i++) {
			sb.append(str[i]+" ");
			
		}
		return sb.toString().trim();
	}
}
