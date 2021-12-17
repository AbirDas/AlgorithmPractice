package Array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		/*
		 * Input: height = [1,8,6,2,5,4,8,3,7]
		 *	Output: 49
		 */
		int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}
	
	public static int maxArea(int[] arr) {
		int answer = 0;
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			if(arr[i]>arr[j]) {
				answer = Math.max(answer, arr[j]*(j-i));
				j--;
			}else {
				answer = Math.max(answer, arr[i]*(j-i));
				i++;
			}
		}
		
		return answer;
	}

}
