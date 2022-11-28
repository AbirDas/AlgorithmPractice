

import java.util.Comparator;
import java.util.Stack;

public class trailTest implements Comparator<String>{

	public static void main(String[] args) {
		/*String[] str = new String[] {"11","10","9"};
		Arrays.sort(str,new trailTest());
		String ans ="";
		for(String s: str) {
			ans +=s;
		}
		System.out.println(ans);*/
		/*int[][] intervals = new int[][] {{0,30},{5,10},{15,20}};
		
		int iLen= intervals.length;
        int jLen=intervals[0].length;
		
		int[] startArray = new int[iLen];
        int[] endArray = new int[jLen];
        for(int i=0,j=0;i<iLen;i++){
            startArray[i] = intervals[i][j];
            endArray[i] = intervals[i][j+1];
        }*/
		/*Queue<Integer> qu = new PriorityQueue<>();
		qu.offer(3);
		qu.offer(1);
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());*/
		
		/*Stack<Character> stack = new Stack<>();
		System.out.println(stack.pop());*/
		
		/*System.out.println(Integer.bitCount(7));
		System.out.println(Integer.toBinaryString(7));
		
		String s1 = "ABCABC";
		String s2 = "ABCA";
		
		System.out.println(s1.substring(s2.length()));*/
		
		/*int bitmask=21;
		System.out.println(bitmask & (-bitmask));
		System.out.println(bitmask & ~(bitmask-1));*/
		
		int i=2, j=8;
		System.out.println((i+j)/2);
		System.out.println(j+(i-j)/2);
	}
	
	
	

	@Override
	public int compare(String o1, String o2) {
		System.out.println("inside comparator o1= "+o1+" , "+"o2= "+o2);
		String ab = o1+o2;
		String ba = o2+o1;
		//System.out.println("inside comparator ab= "+ab+" , "+"ba= "+ba);
		int res = ab.compareTo(ba)>1 ? -1:1;
		//System.out.println("inside comparator res "+res);
		return res;
	}


}
