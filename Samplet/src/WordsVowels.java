import java.util.Scanner;

public class WordsVowels {

	public static void main(String[] arg0) {
		/*
		 * Scanner scan = new Scanner(System.in); int input = scan.nextInt();
		 * scan.nextLine(); String s = ""; for (int i = 0; i < input; i++) { s =
		 * scan.nextLine(); findWordsVowel(s); scan.nextLine(); }
		 */
		findWordsVowel("Hi  there");
	}

	public static void findWordsVowel(String st) {
		int vCount = 0, cCount = 0, wCount = 1;
		String str = st.toLowerCase().trim();
		char[] arr = str.toCharArray();
		int i = 0;
		while (i < arr.length) {

			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vCount++;
				i++;
			} else if (arr[i] != ' ') {
				cCount++;
				i++;
			} else if (arr[i] == ' ') {
				wCount++;
				i++;
				while (arr[i] == ' ') {
					i++;
				}
			}

		}

		System.out.println(wCount + " " + vCount + " " + cCount);

	}
}
