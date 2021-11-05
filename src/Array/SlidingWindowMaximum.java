package Array;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
		//Output: [3,3,5,5,6,7]
	}

	    public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums==null) return new int[0];
	        if(k == 1) return nums;
	        int len = nums.length;
	        if(len < 1 || k == 0) return new int[0];
	        
	        int[] left = new int[len];
	        int[] right = new int[len];
	        left[0] = nums[0];
	        right[len-1] = nums[len-1];
	        
	        for(int i=1; i<len; i++) {
	            if(i%k==0) {
	                left[i] = nums[i];
	            }
	            else {
	                left[i] = Math.max(left[i-1],nums[i]);
	            }
	            
	            int j=len-1-i;
	            if((j+1)%k==0){
	                right[j] = nums[j];
	            } 
	            else {
	                right[j] = Math.max(right[j+1],nums[j]);
	            }
	        }
	        
	        int[] answer = new int[len-(k-1)];
	        for(int i=0; i<len-(k-1); i++) {
	            answer[i] = Math.max(right[i],left[i+(k-1)]);
	        }
	        return answer;
	    }
	
}
