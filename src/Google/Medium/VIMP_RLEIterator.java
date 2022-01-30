package Google.Medium;

public class VIMP_RLEIterator {

	public static void main(String[] args) {
		/*
		Input
		["RLEIterator", "next", "next", "next", "next"]
		[[[3, 8, 0, 9, 2, 5]], [2], [1], [1], [2]]
		Output
		[null, 8, 8, 5, -1]

		Explanation
		RLEIterator rLEIterator = new RLEIterator([3, 8, 0, 9, 2, 5]); // This maps to the sequence [8,8,8,5,5].
		rLEIterator.next(2); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
		rLEIterator.next(1); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
		rLEIterator.next(1); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
		rLEIterator.next(2); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5,
		but the second term did not exist. Since the last term exhausted does not exist, we return -1.
		*/
	}
	
	class RLEIterator {
	    int[] arr;
	    int index;
	    int count;
	    
	    public RLEIterator(int[] encoding) {
	        arr = encoding;
	        index=0;
	        count=arr[0];
	    }
	    
	    public int next(int n) {
	        while(index<arr.length){
	            if(n>count){
	                n -=count;
	                index +=2;
	                if(index<arr.length){
	                    count = arr[index];
	                }
	            }else{
	                count -=n;
	                return arr[index+1];
	            }         
	        }
	        return -1;
	    }
	}

	/**
	 * Your RLEIterator object will be instantiated and called as such:
	 * RLEIterator obj = new RLEIterator(encoding);
	 * int param_1 = obj.next(n);
	 */

}
