package BitManipulation;

public class SingleNumber_NonRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] nums) {
		int ans = 0;
		for(int i : nums) {
			ans = ans ^ i;
		}
		return ans;
	}

}
