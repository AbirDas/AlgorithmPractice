package Google.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,6,8};
		print(findOriginalArray(arr));
	}

	public static int[] findOriginalArray(int[] changed) {
		if (changed == null || changed.length < 2 || ((changed.length % 2) != 0))
			return new int[0];

		int len = changed.length;
		int idx = (len / 2) - 1;
		int[] answer = new int[idx + 1];

		Map<Integer, Integer> counter = new HashMap<>();

		Arrays.sort(changed);

		for (int i = len - 1; i >= 0; i--) {
			int value = changed[i];
			int twice = value * 2;

			if (counter.containsKey(twice)) {
				if (counter.get(twice) == 1)
					counter.remove(twice);
				else
					counter.put(twice, counter.get(twice) - 1);
				answer[idx] = value;
				idx--;
			} else {
				counter.put(value, counter.getOrDefault(value, 0) + 1);
			}
		}

		return idx < 0 ? answer : new int[0];
	}
	
	private static void print(int[] arr) {
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			if(i<arr.length -1) {
				System.out.print(arr[i]+",");
			}else {
				System.out.print(arr[i]);
			}
			
		}
		System.out.print("]");
	}

}
