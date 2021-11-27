package Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	public static void main(String[] args) {
		System.out.println(new _3Sum().threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<List<Integer>>();
        return threeSum(nums,0);
    }
    
    public List<List<Integer>> threeSum(int[] nums,int target) {
        Arrays.sort(nums);
        if(nums[0] > target) return new ArrayList<List<Integer>>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length && nums[i]<=target; i++) {
            if(i==0 || nums[i-1] != nums[i]) {
                twoSum(nums,target,i,answer);
            }
        }
        return answer;
    }
    
    public void twoSum(int[] nums,int target,int i,List<List<Integer>> answer) {
        int lo= i+1, hi= nums.length -1;
        while(lo<hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum > target){
                hi--;
            }else if(sum < target) {
                lo++;
            }else{
                answer.add(Arrays.asList(nums[i] , nums[lo] , nums[hi]));
                lo++;
                while(lo<hi && nums[lo-1]==nums[lo]){
                    lo++;
                }
                hi--;
                while(lo<hi && nums[hi+1]==nums[hi]){
                    hi--;
                }
            }
        }
    }

}
