package BitManipulation;

public class SingleNumber_NonRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//input [4,1,2,1,2]
	//output 4
	public int singleNumber_FromTwo(int[] nums) {
		int ans = 0;
		for(int num : nums) {
			ans = ans ^ num;
		}
		return ans;
	}

	//input [0,1,0,1,0,1,99]
	//output 99
	public int singleNumber_FromThree(int[] nums) {
		int single = 0, twice = 0;
        for(int num : nums) {
            single = ~twice & (single ^ num);
            twice = ~single & (twice ^ num);
        }
        return single;
	}
	
	//input [1,2,1,3,2,5]
	//output [3,5]
	public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        
        int num1 = 0, num2 = 0;
        int xor = nums[0];
        for(int i=1; i<nums.length; i++) {
            xor = xor ^ nums[i];
        }
        
        int diff = xor & ~(xor-1);
        
        for(int num : nums) {
            if((diff & num) > 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }
        return new int[]{num1,num2};
    }
}
