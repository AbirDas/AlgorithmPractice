package Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

	public static void main(String[] args) {
		System.out.println(new _4Sum().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(nums==null || nums.length < 4) return answer;
        Arrays.sort(nums);
        for(int i=0; i<nums.length ; i++){
            if(i==0 || nums[i-1]!=nums[i]){
                int diff = target - nums[i];
                threeSum(nums,diff,i,answer);
            }
        }
        return answer;
    }
    
    public void threeSum(int[] nums, int target, int i, List<List<Integer>> answer) {
        for(int j=i+1; j<nums.length ; j++) {
            if(j==i+1 || nums[j-1]!=nums[j]) {
                twoSum(nums,target,i,j,answer);
            }
        }
    }
    
    public void twoSum(int[] nums, int target,int i,int j,List<List<Integer>> answer) {
        int lo=j+1, hi=nums.length-1;
        
        while(lo<hi) {
            int sum = nums[j] + nums[lo] + nums[hi];
            if(sum<target){
                lo++;
            }else if(sum>target){
                hi--;
            }else{
                answer.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                lo++;
                while(lo<hi && nums[lo-1]==nums[lo]) lo++;
                hi--;
                while(lo<hi && nums[hi+1]==nums[hi]) hi--;
            }
        }
    }

}
