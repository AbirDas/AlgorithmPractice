package Array;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = {1,4,6};
		int[] b = {2,5,7,9};
		System.out.println(findMedianSortedArrays(a, b));
	}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if(x>y) return findMedianSortedArrays(nums2,nums1);
        
        int left = 0;
        int right = x;
        
        while(left<=right) {
            int xPart = (left+right)/2;
            int yPart = ((x+y+1)/2)-xPart;
            
            int xLeft = (xPart==0) ? Integer.MIN_VALUE : nums1[xPart-1];
            int xRight = (xPart==x) ? Integer.MAX_VALUE : nums1[xPart];
            int yLeft = (yPart==0) ? Integer.MIN_VALUE : nums2[yPart-1];
            int yRight = (yPart==y) ? Integer.MAX_VALUE : nums2[yPart];
            
            if(xLeft<=yRight && yLeft<=xRight) {
                if((x+y)%2==0){
                    return (double)(Math.max(xLeft,yLeft) + Math.min(xRight,yRight))/2;
                }else{
                    return (double)Math.max(xLeft,yLeft);
                }
            }
            if(xLeft > yRight){
                right = xPart-1;
            }else{
                left = xPart+1;
            }
        }
        
        return 0;
    }
	
}
