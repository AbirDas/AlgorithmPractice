package Queue_Stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IMP_OpenTheLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        Set<String> dead = new HashSet();
        for(String deadend : deadends){
            dead.add(deadend);
        } 
        Set<String> visited = new HashSet();
        
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        //visited.add("0000");
        
        int ans = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String temp = queue.poll();
                //System.out.println("temp = "+temp);
                if(temp.equals(target)) {
                    return ans;
                }
                
                if(dead.contains(temp)) {
                    continue;
                }
                
                
                for(int j=0; j<4; j++) {
                    char digit = temp.charAt(j);
                    String str1= temp.substring(0, j)+ (digit == '9' ? "0": ((digit-'0')+1))+ temp.substring(j+1);           
                    String str2= temp.substring(0, j)+ (digit == '0' ? "9": ((digit-'0')-1))+ temp.substring(j+1);             
                    
                    if(!dead.contains(str1) && !visited.contains(str1)) {
                       // System.out.println("str1 = "+str1);
                        queue.offer(str1);
                        visited.add(str1);
                    }
                    
                    if(!dead.contains(str2) && !visited.contains(str2)) {
                        //System.out.println("str2 = "+str2);
                        queue.offer(str2);
                        visited.add(str2);
                    }
                }
                
            }
            ans++;
        }
        return -1;
    }

}
