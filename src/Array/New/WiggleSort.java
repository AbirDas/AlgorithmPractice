package Array.New;

public class WiggleSort {

	public static void main(String[] args) {
		/*
		 * Example 1:
		 * Input: nums = [3,5,2,1,6,4]
		 * Output: [3,5,1,6,2,4]
		 * Explanation: [1,6,2,5,3,4] is also accepted.
		 * 
		 * Example 2:
		 * Input: nums = [6,6,5,6,3,8]
		 * Output: [6,6,5,6,3,8]
		 */

	}
	
	public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2) {
            return;
        }

        for(int i=0; i<nums.length-1; i++) {
            if((i%2==0 && nums[i]>nums[i+1]) || (i%2==1 && nums[i]<nums[i+1])) {
                swap(nums,i,i+1);
            } 
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
