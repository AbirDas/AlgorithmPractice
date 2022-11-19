package BitManipulation;

public class Numberof1Bits_HammingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// you need to treat n as an unsigned value
    public int hammingWeigh1t(int n) {
        if(n==0) return 0;
        int count =0;
        int mask = 1;
        for(int i=0; i<32; i++) {
            if((n & mask) !=0) {
                count++;
            }
            mask = mask<<1;
        }
        return count;
    }
    
    public int hammingWeight2(int n) {
        if(n==0) return 0;
        int count =0;
        
        while(n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

}
