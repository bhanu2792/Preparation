package Test;

public class que1 {
 
  public static String compressedString(String message) {
    // Write your code here

    int len = message.length();
    int count = 1;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < len - 1; i++) {
      if (message.charAt(i) == message.charAt(i + 1)) {
        count++;
      } else {
        if (count == 1) {
          sb.append(message.charAt(i));
        } else {
          sb.append(message.charAt(i));
          sb.append(count);
        }
        count = 1;
      }
    }
    sb.append(message.charAt(len - 1));
    if (count > 1) {
       sb.append(count);
    }
    return sb.toString();
  }
  
      public static void main(String[] arg0) {
        
       String st = compressedString("alaasass");
       System.out.println(st);
        
      }
      
      
  }


