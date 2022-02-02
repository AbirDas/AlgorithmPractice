package Google.Hard;

public class IMP_SplitArrayLargestSum {

	public static void main(String[] args) {
		/*
		Input: nums = [7,2,5,10,8], m = 2
		Output: 18
		Explanation:
		There are four ways to split nums into two subarrays.
		The best way is to split it into [7,2,5] and [10,8],
		where the largest sum among the two subarrays is only 18.
		*/
		int[] nums = {7,2,5,10,8};
		System.out.println(splitArray(nums,2));
	}

	public static int splitArray(int[] nums, int m) {
		if(nums==null || m==0 || nums.length<1) return 0;
		
		int totalSum=0;
		int maxNum=0;
		for(int num : nums) {
			totalSum +=num;
			maxNum = Math.max(maxNum, num);
		}
		
		int answer=0;
		int left=maxNum;
		int right=totalSum;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(minSubArrayRequired(nums,mid)<=m) {
				right = mid-1;
				answer = mid;
			}else {
				left = mid+1;
			}
		}
		return answer;
	}
	
	private static int minSubArrayRequired(int[] nums, int maxAllodedSplit) {
		int count=0;
		int splitRequired=0;
		
		for(int num : nums) {
			if(count+num<=maxAllodedSplit) {
				count +=num;
			}else {
				count=num;
				splitRequired++;
			}
		}
		return splitRequired+1;
	}
}
