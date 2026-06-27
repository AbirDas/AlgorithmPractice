package Sum;

import java.util.HashMap;
import java.util.Map;

public class _2Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> value = new HashMap();
        int len = nums.length;
        for (int i=0; i<len; i++) {
            int reqTarget = target - nums[i];
            if(value.containsKey(reqTarget) && value.get(reqTarget)!=i) {
                return new int[]{value.get(reqTarget),i};
            }
            value.put(nums[i],i);
        }
        return null;
    }
	

}
