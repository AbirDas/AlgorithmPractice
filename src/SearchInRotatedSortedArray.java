
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getRotationIndex(new int[]{11,12,13,24,5,6}));
		System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
	}
	
	//working
	public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
	
	public static int getRotationIndex(int[] nums) {
		int pivot = 0;
		int left = 0;
		int right = nums.length-1;
		if(nums[left]<nums[right]) {
			return pivot;
		}
		
		while(left<=right) {
			pivot = (left+right)/2;
			//if(nums[pivot-1]>nums[pivot] && nums[pivot]<nums[pivot+1]) {
			if(pivot==0 && nums[pivot]>nums[pivot+1]) {
				return pivot+1;
			}else if(nums[pivot-1]>nums[pivot] && nums[pivot]<nums[pivot+1]) {
				return pivot;
			}
			else{
				if(nums[left]<nums[pivot]) {
					left=pivot+1;
				}else {
					right=pivot-1;
				}
			}
		}
		
		return 0;
	}
	
	public static int find(int[] nums, int left, int right, int target) {
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static int findElement(int[] nums, int target) {
		if(nums==null || nums.length == 0) return -1;
		int len = nums.length -1;
		if(len==0) {
			if(nums[len]==target) {
				return len;
			}else {
				return -1;
			}
		}
		
		int pivot = getRotationIndex(nums);
		if(nums[pivot] == target) return pivot;
		
		if(pivot == 0){
			return find(nums,0,len,target);
		}
		
		int left = find(nums,0,pivot-1,target);
		int right = find(nums,pivot+1,len,target);
		
		return left!=-1? left: right;
	}

}
