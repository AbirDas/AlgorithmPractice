package Array.New;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {

	public static void main(String[] args) {
		/*
		 * 1056. Confusing Number
		 */
	}
	
	public boolean confusingNumber(int n) {
        Map<Integer,Integer> revInt = new HashMap<Integer,Integer>();
        revInt.put(0,0);
        revInt.put(1,1);
        revInt.put(6,9);
        revInt.put(8,8);
        revInt.put(9,6);

        int nCopy = n;
        int confNum = 0;

        while(nCopy>0) {
            int rem = nCopy%10;

            if(!revInt.containsKey(rem)) {
                return false;
            }

            confNum = (confNum * 10) + revInt.get(rem);
            nCopy = nCopy/10;
        }

        return confNum!=n;
    }

}
