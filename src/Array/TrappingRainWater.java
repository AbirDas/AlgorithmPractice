package Array;

public class TrappingRainWater {

    public static void main(String[] args) {
        /*
         * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
         * Output: 6
         * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
         * In this case, 6 units of rain water (blue section) are being trapped.
         */
    }

    public int trap(int[] height) {
        if(height==null || height.length<3) return 0;
        /*int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len-1] = height[len-1];

        for(int i=1, j=len-2; i<len && j>=0; i++,j--) {
            left[i] = Math.max(left[i-1],height[i]);
            right[j] = Math.max(right[j+1], height[j]);
        }

        int ans=0;
        for(int i=1; i<(len-1); i++) {
            int value = Math.min(left[i-1],right[i+1]) - height[i];
            ans += Math.max(0, value);
        }
        return ans;*/

        int leftMax=0,rightMax=0;
        int ans=0,left=0,right=height.length-1;

        while(left<right) {
            if(leftMax<height[left]) {
                leftMax = height[left];
            }
            if(rightMax<height[right]) {
                rightMax = height[right];
            }
            if(leftMax<rightMax) {
                ans += Math.max(0, leftMax-height[left]);
                left++;
            } else {
                ans += Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return ans;
    }

}
