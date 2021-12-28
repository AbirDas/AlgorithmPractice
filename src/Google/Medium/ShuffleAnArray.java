package Google.Medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
	// Fisher-Yates Algorithm
	
	int[] arr;
	Random ran;

	public ShuffleAnArray(int[] nums) {
		arr = nums;
		ran = new Random();
	}

	public int[] reset() {
		return arr;
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public int[] shuffle() {
		// int[] numRan = arr.clone();
		int[] numRan = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < numRan.length; i++) {
			swap(numRan, i, ran.nextInt(numRan.length));
		}
		return numRan;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		ShuffleAnArray s = new ShuffleAnArray(nums);
		s.print(s.shuffle());
		s.print(s.reset());
		s.print(s.shuffle());
	}

	private void print(int[] nums) {
		for(int i : nums) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	

	/**
	 * Your Solution object will be instantiated and called as such: Solution obj =
	 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */

}
