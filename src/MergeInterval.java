import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		// [[1,3],[2,6],[8,10],[15,18]]
		System.out.println(merge(new int[][] {{1,3},{2,6},{8,10},{15,18},{16,20}}));
	}
	
	
    public static int[][] merge(int[][] intervals) {
        if(intervals==null) return new int[0][0];
        if(intervals.length<=1) return intervals;
        int len = intervals.length;
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        int[] startArray = new int[len];
        int[] endArray = new int[len];
        
        for(int i=0,j=0; i<len; i++){
            startArray[i] = intervals[i][j];
            endArray[i] = intervals[i][j+1];
        }
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        
        int start = startArray[0];
        int end = endArray[0];
        int i=1,j=1;
        
        while(i<len) {
            if(startArray[i]>end){
                answer.add(Arrays.asList(start,end));
                
                if(i==len) break;//not required
                start = startArray[i];
                end = endArray[j];
            }else{
                end = endArray[j];
               // i++;j++;
                //if(i==len) answer.add(Arrays.asList(start,end));
            }
            i++; j++;
            if(i==len) answer.add(Arrays.asList(start,end));
        }
        
        int[][] ans = new int[answer.size()][2];
        int it = 0;
        for(List<Integer> value : answer) {
            for(int a = 0; a<value.size(); a++){
               // System.out.println("a = "+value.get(a));
                ans[it][a] = value.get(a);
            }
            it++;
        }
        
        return ans;
    }

}
