package Array.New;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {

	public static void main(String[] args) {
		/*
		 * 624. Maximum Distance in Arrays
		 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
		 * Output: 4
		 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
		 */
		List<List<Integer>> problem = new ArrayList<List<Integer>>();
		problem.add(Arrays.asList(1,2,3));
		problem.add(Arrays.asList(4,5));
		problem.add(Arrays.asList(1,2,3));
		System.out.println(new MaximumDistanceInArrays().maxDistance(problem));
		
	}
	
	
	public int maxDistance(List<List<Integer>> arrays) {
		if(arrays==null || arrays.size()<2) {
			return 0;
		}
		
		int ans = 0;
		int len = arrays.size();
		
		int currMin = arrays.get(0).get(0);
		int currMax = arrays.get(0).get(len-1);
		
		for(int i=1; i<len; i++) {
			List<Integer> nextArray = arrays.get(i);
			int nextLen = nextArray.size();
			
			int nextMin = nextArray.get(0);
			int nextMax = nextArray.get(nextLen-1);
			
			ans = Math.max(ans, Math.max(currMax-nextMin, nextMax-currMin));
			
			currMin = Math.min(currMin,nextMin);
			currMax = Math.max(currMax, nextMax);
		}
		return ans;
	}
}
