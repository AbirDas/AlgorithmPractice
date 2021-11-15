package Array;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
	}
	
	
    public static int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        int len = heights.length;
        int pos = 0;
        int[] leftLess = new int[len];
        int[] rightLess = new int[len];
        leftLess[0] = -1;
        rightLess[len-1] = len;
        int max = 0;
        
        for(int i=1; i<len; i++) {
            pos = i-1;
            while(pos>=0 && heights[pos]>=heights[i]){
                pos = leftLess[pos];
            }
            leftLess[i] = pos;
        }
        
        for(int i=len-2; i>=0; i--) {
            pos = i+1;
            while(pos<len && heights[pos]>=heights[i]) {
                pos = rightLess[pos];
            }
            rightLess[i] = pos;
        }
        
        for(int i=0; i<len; i++) {
            int width = rightLess[i] - leftLess[i] - 1;
            int value = heights[i] * width;
            if(value>0 && value>max) max = value;
        }
       return max; 
    }

}
