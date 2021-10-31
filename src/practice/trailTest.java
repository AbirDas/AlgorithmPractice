package practice;

import java.util.Arrays;
import java.util.Comparator;

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
		
		System.out.println(3%4);
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
