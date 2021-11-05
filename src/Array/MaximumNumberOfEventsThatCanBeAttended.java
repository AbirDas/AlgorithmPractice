package Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxEvents(int[][] events) {
        if(events==null) return 0;
        if(events.length==1) return 1;
        
        int len = events.length;
        int i=0,day=0,answer=0;
        Arrays.sort(events, (e1,e2) -> {
            int l1 = e1[0] - e2[0];
            int l2 = e1[1] - e2[1];
            return (l1==0) ? l2 : l1;
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        while(i<len || !pq.isEmpty()) {
            if(pq.isEmpty()) day = events[i][0];
            
            while(i<len && day==events[i][0]) {
                pq.offer(events[i][1]);
                i++;
            }
            
            if(pq.poll()!=null){
                answer++;
                day++;
            }
            
            while(!pq.isEmpty() && day>pq.peek()) pq.poll();
        }
        return answer;
    }

}
