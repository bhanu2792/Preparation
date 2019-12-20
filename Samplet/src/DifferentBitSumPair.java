import java.util.ArrayList;

public class DifferentBitSumPair {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(3);
	    list.add(5);
	    DifferentBitSumPair o = new DifferentBitSumPair();
	   int c=  o.cntBits(list);
	   System.out.println("Count is" + c);
	}

	
	public int cntBits(ArrayList<Integer> A) {
        int size = A.size();
        int sum=0;
        for (int i =0; i<size; i++){
            for (int j =0; j<size; j++){
                int num = A.get(i)^A.get(j);
                System.out.println("Number is" + num);
                
                int count = checkBit(num);
                sum= (sum + count);
            }
        }
        
        return sum;
        
    }
    
    public int checkBit(int num){
        int countBit=0;
        while (num != 0){
            if (num%2==1){
                countBit++;
            }
            num=num>>1;
        }
        return countBit;
    }
}
