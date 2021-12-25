package Array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(arr));
	}

	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, Integer> left = new HashMap<>();
		Map<Integer, Integer> right = new HashMap<>();

		int degree = 0;

		for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
			degree = Math.max(degree, count.get(nums[i]));

			if (left.get(nums[i]) == null)
				left.put(nums[i], i);

			if (right.get(nums[j - i]) == null)
				right.put(nums[j - i], j - i);
		}

		int min = Integer.MAX_VALUE;
		for (int num : count.keySet()) {
			if (count.get(num) == degree) {
				min = Math.min(min, (right.get(num) - left.get(num)) + 1);
			}
		}
		return min;
	}

}
