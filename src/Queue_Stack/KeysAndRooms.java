package Queue_Stack;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null) return false;
        
        int len = rooms.size();
        boolean[] visited = new boolean[len];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        visited[0] = true;
        
        while(!stack.isEmpty()) {
            int currRoom = stack.pop();
            
            for(int key : rooms.get(currRoom)) {
                if(!visited[key]) {
                    stack.push(key);
                    visited[key] = true;
                }
            }
        }
        
        for(boolean v : visited) {
            if(!v) return false;
        }
        
        return true;
    }

}
