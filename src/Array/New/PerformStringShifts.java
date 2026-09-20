package Array.New;

public class PerformStringShifts {

	public static void main(String[] args) {
		/*
		 * Input: s = "abc", shift = [[0,1],[1,2]]
		 * Output: "cab"
		 * Explanation: 
		 * [0,1] means shift to left by 1. "abc" -> "bca"
		 * [1,2] means shift to right by 2. "bca" -> "cab"
		 */
	}
	
	public String stringShift(String s, int[][] shift) {
        int[] overallShift = new int[2];
        for(int[] move : shift) {
            overallShift[move[0]] += move[1];
        }

        int leftShift = overallShift[0];
        int rightShift = overallShift[1];
        String ans = null;
        int len = s.length();
        if(leftShift>rightShift) {
            leftShift = (leftShift-rightShift) % len;
            ans = s.substring(leftShift) + s.substring(0,leftShift);
        } else if(rightShift>leftShift) {
            rightShift = (rightShift-leftShift) % len;
            ans = s.substring(len-rightShift) + s.substring(0,len-rightShift);
        } else {
            return s;
        }
        return ans;
    }

}
