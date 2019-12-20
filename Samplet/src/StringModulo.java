
public class StringModulo {

	
	long modulo(String str, long div){
	    long result = 0;
	    long s = 100000000;
	    for (int i=0; i<str.length(); i++){
	         result = ((result*10 + ((int)str.charAt(i)-'0'))%div);
	    }
	    
	    return result;
	}
}
