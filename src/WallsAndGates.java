import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	public static void main(String[] args) {
		WallsAndGates wg = new WallsAndGates();
		int[][] question = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		wg.wallsAndGates(question);
	}
	
	public void print(int[][] rooms) {
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				System.out.print(rooms[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        
        int a = rooms.length;
        int b = rooms[0].length;
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[a][b];
        
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                if(rooms[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        int curr = 0;
        while(!queue.isEmpty()) {
            curr++;
            int sz = queue.size();
            for(int iter=0; iter<sz; iter++) {
                int[] pq = queue.poll();
                
                for(int[] dir : dirs) {
                    int pt1 = pq[0] + dir[0];
                    int pt2 = pq[1] + dir[1];

                    if(pt1>=0 && pt1<a && pt2>=0 && pt2<b && rooms[pt1][pt2]>0) {
                        if(!visited[pt1][pt2]){
                            visited[pt1][pt2] = true;
                            rooms[pt1][pt2] = curr;
                            queue.add(new int[]{pt1,pt2});
                        }/*else if(rooms[pt1][pt2] > curr) {
                            rooms[pt1][pt2] = curr;
                        }*/
                        
                    }
                }
            }
        }
        print(rooms);
    }
	

}
