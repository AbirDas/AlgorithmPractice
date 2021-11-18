package Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3,1},5));
	}
	
    public static int subarraysDivByK(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int sum =0, rem=0;
        
        for(int i=0; i<nums.length; i++) {
            sum +=nums[i];
            rem = sum%k;
            if(rem<0){
                rem +=k;
            }
            
            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }
        return ans;
    }

}
