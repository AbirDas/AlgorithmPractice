package Recursion;

import java.util.HashSet;
import java.util.Set;  

public class GridIllumination {
	
	int[][] lampArray;
	int[][] lampPosition;
    int noOfLamp=0;
    int len;
    int[] answer;

	public static void main(String[] args) {
		/*5
		[[0,0],[4,4]]
		[[1,1],[1,0]]
		
		5
		[[0,0],[0,4]]
		[[0,4],[0,1],[1,4]]
		
		6
		[[2,5],[4,2],[0,3],[0,5],[1,4],[4,2],[3,3],[1,0]]
		[[4,3],[3,1],[5,3],[0,5],[4,4],[3,3]]
		*/
		GridIllumination g = new GridIllumination();
		int[][] lamps = {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}};
		int[][] queries = {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}};
		g.gridIllumination(6,lamps, queries);
		g.print();
	}
	
	private void print() {
		for(int i : answer)
			System.out.println(i);
	}
	
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //if(n==0) return new int[]{0};
        len=n;
        lampArray = new int[n][n];
        lampPosition = new int[n][n];
        answer = new int[queries.length];
        
        for(int[] lamp : lamps) {
        	if(lampPosition[lamp[0]][lamp[1]] == 1) {
        		continue;
        	}
            noOfLamp++;
            //lampSet.add(new Pair(lamp[0],lamp[1]));
            lampPosition[lamp[0]][lamp[1]] = 1;
            turnOnOff(lamp[0],lamp[1],true);
        }
        
        int ittr=0;
        for(int[] querie : queries) {
            if(noOfLamp==0) {
                answer[ittr] = 0;
            }else {
                checkIlluminate(querie[0], querie[1],ittr);
                int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1},{0,0}};
                for(int[] direction : directions) {
                	int col = querie[0] + direction[0];
                	int row = querie[1] + direction[1];
                	if(col<0 || col>=len || row<0 || row>=len) {
                		continue;
                	}
                    if(lampPosition[col][row]==1) {
                        --noOfLamp;
                        lampPosition[col][row]=0;
                        turnOnOff(col,row,false);
                    }
                }
            }
            ++ittr;
        }  
        return answer;
    }
    
    private void checkIlluminate(int col, int row,int ittr) {
        if(lampArray[col][row]>0) {
            answer[ittr] = 1;
        } else {
        	answer[ittr] = 0;
        }   
    }
                       
    private void action(int col, int row, boolean status) {
        if(status) {
            lampArray[col][row] += 1;
        }else {
            lampArray[col][row] -= 1;
        }
    }
    
    private void turnOnOff(int col, int row, boolean status) {
        action(col,row,status);
        
        //vertical-up
        for(int i=col-1,j=row; i>=0; i--) {
            action(i,j,status); 
        }
        //vertical-down
        for(int i=col+1,j=row; i<len; i++) {
            action(i,j,status); 
        }
        
        //horizontal-left
        for(int i=col,j=row-1; j>=0; j--) {
            action(i,j,status); 
        }
        //horizontal-right
        for(int i=col,j=row+1; j<len; j++) {
            action(i,j,status); 
        }
        
        //diagonal-left-up
        for(int i=col-1,j=row-1; i>=0 && j>=0; i--,j--) {
            action(i,j,status); 
        }
        //diagonal-left-down
        for(int i=col+1,j=row-1; i<len && j>=0; i++,j--) {
            action(i,j,status); 
        }
        //diagonal-right-up
        for(int i=col-1,j=row+1; i>=0 && j<len; i--,j++) {
            action(i,j,status); 
        }
        //diagnol-right-down
        for(int i=col+1,j=row+1; i<len && j<len; i++,j++) {
            action(i,j,status); 
        }
    }

}
