package Array;

public class GetTheMaximumScore {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] {2,4,5,8,10}, new int[] {4,6,8,9}));
	}

    public static int maxSum(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0;
        long s1=0,s2=0,max=0;
        
        while(i<n && j<m) {
            if(nums1[i]<nums2[j]) {
                s1 += nums1[i];
                i++;
            }else if(nums1[i]>nums2[j]) {
                s2 += nums2[j];
                j++;
            }else{
                max += Math.max(s1,s2) + nums1[i];
                i++;
                j++;
                s1=0;
                s2=0;
            }
        }
        
        while(i<n) {
            s1 +=nums1[i];
            i++;
        }
        
        while(j<m) {
            s2 +=nums2[j];
            j++;
        }
        
        return (int)((max + Math.max(s1,s2))%1000000007);
    }
}
