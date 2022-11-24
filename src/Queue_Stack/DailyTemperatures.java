package Queue_Stack;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] dailyTemperatures(int[] temperatures) {
		if(temperatures==null || temperatures.length==1) return new int[1];
		int len = temperatures.length;
		int[] ans = new int[len];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int currPos=0; currPos<len; currPos++) {
			int currTemp = temperatures[currPos];
			while(!stack.isEmpty() && currTemp>temperatures[stack.peek()]) {
				int prePos = stack.pop();
				ans[prePos] = currPos-prePos;
			}
			stack.push(currPos);
		}
		return ans;
	}

}
