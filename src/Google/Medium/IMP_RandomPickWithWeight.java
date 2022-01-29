package Google.Medium;

public class IMP_RandomPickWithWeight {

	public static void main(String[] args) {
		/*
		Input
		["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
		[[[1,3]],[],[],[],[],[]]
		Output
		[null,1,1,1,1,0]
		
		Explanation
		Solution solution = new Solution([1, 3]);
		solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
		solution.pickIndex(); // return 1
		solution.pickIndex(); // return 1
		solution.pickIndex(); // return 1
		solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
		
		Since this is a randomization problem, multiple answers are allowed.
		All of the following outputs can be considered correct:
		[null,1,1,1,1,0]
		[null,1,1,1,1,1]
		[null,1,1,1,0,0]
		[null,1,1,1,0,1]
		[null,1,0,1,0,0]
		*/
	}
	
	class Solution {
	    
	    int[] prefixs;
	    int totalSum;

	    public Solution(int[] w) {
	        prefixs = new int[w.length];
	        
	        int prefix=0;
	        for(int i=0; i<w.length; i++) {
	            prefix +=w[i];
	            prefixs[i] = prefix;
	        }
	        totalSum = prefix;
	    }
	    
	    public int pickIndex() {
	        double target = totalSum * Math.random();
	        
	        /*int i=0;
	        for(;i<prefixs.length; i++) {
	            if(target<prefixs[i])
	                return i;
	        }
	        return i-1;*/
	        
	        int low=0, high=prefixs.length;
	        
	        while(low<high) {
	            int  mid = (low+high)/2;
	            if(target>prefixs[mid]) {
	                low = mid+1;
	            }else{
	                high = mid;
	            }
	        }
	        return low;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(w);
	 * int param_1 = obj.pickIndex();
	 */

}
