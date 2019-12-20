
public class DigitToWord {

	public static void convertToword(char[] ch) {
		int len = ch.length;

		String[] single = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		String[] dual = { "", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		
		String[] mulTen = {"", "", "twenty", "thirty", "forty",  
                "fifty","sixty", "seventy",  
                "eighty", "ninety"};

		String[] ten = { "hundred", "thousand" };

		if (len == 0)
			return;

		if (len == 1) {
			int val = ch[0] - '0';
			System.out.println("" + single[val]);

		}

		int x = 0;
		while (x < ch.length) {
			if (len >= 3) {
               int v = ch[x] - '0'; 
               if (v != 0) {
			       System.out.println(single[v]);
			       System.out.println(ten[len-3]);
               }
               len--;
			} else {
				if (len == 2 ) {
					if ((ch[x] - '0') == '1') {
						System.out.println(dual[ch[x+1]-'0']);
					} else if ((ch[x] - '0') == '2' && (ch[x+1] - '0') == '0') {
						System.out.println("Twenty");
					} else {
						System.out.println(mulTen[ch[x] - '0']);
					}
					len--;
				} else {
					System.out.println(single[ch[x] - '0']);
				}
				
			}
			x++;
		}
	}

	public static void main(String[] args) {

		convertToword("322".toCharArray());

	}

}
