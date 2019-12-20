
public class RomToInt {

	public static void main(String[] arg0) {
		System.out.println(romToint("XIV"));
	}

	public static int romToint(String A) {
		int len = A.length();
		int num = 0;
		for (int i = 1; i < len; i++) {
			if (getNum(A.charAt(i - 1)) >= getNum(A.charAt(i))) {
				num = num + getNum(A.charAt(i - 1));
			} else {
				num = num - getNum(A.charAt(i - 1));
			}
		}
		num = num + getNum(A.charAt(len - 1));

		return num;
	}

	public static int getNum(char c) {
		int number = 0;
		switch (c) {
		case 'I':
			number = 1;
			break;
		case 'V':
			number = 5;
			break;
		case 'X':
			number = 10;
			break;
		case 'L':
			number = 50;
			break;
		case 'C':
			number = 100;
			break;
		case 'D':
			number = 500;
			break;
		case 'M':
			number = 1000;
			break;
		default:
			break;
		}

		return number;
	}
}
