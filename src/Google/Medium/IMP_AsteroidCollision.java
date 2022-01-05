package Google.Medium;

import java.util.Stack;

public class IMP_AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,-3};
		print(asteroidCollision(arr));
	}

	public static int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null && asteroids.length < 2)
			return asteroids;
		Stack<Integer> st = new Stack<>();

		int itt = 0;

		while (itt < asteroids.length) {
			if (st.isEmpty()) {
				st.push(asteroids[itt]);
				itt++;
			} else {
				int pre = st.peek();
				if (pre > 0 && asteroids[itt] < 0) {
					
					int curr = Math.abs(asteroids[itt]);

					if (curr <= pre)
						itt++;

					if (curr >= pre)
						st.pop();
				} else {
					st.push(asteroids[itt]);
					itt++;
				}
			}
			// itt++;
		}
		return convertToArray(st);
	}

	private static int[] convertToArray(Stack<Integer> st) {
		int[] ans = new int[st.size()];
		for (int i = st.size() - 1; i >= 0; i--) {
			ans[i] = st.pop();
		}
		return ans;
	}

	private static void print(int[] arr) {
		for(int a : arr) System.out.print(a+" ");
	}
}
