package Array;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

    int iLen=0,jLen=0;
    boolean needBacktrace=false;
    
    public void solveSudoku(char[][] board) {
        iLen=board.length;
        jLen=board[0].length;
        dfs(board,0,0);
    }
    
    public void dfs(char[][] board, int i, int j) {
        
        if(i==iLen){
            needBacktrace=true;
            return;
        } 
        
        int ni=0,nj=0;
        if(j==jLen-1){
            ni=i+1;
            nj=0;
        }else{
            ni=i;
            nj=j+1;
        }
        
     
        if(board[i][j]!='.'){
            dfs(board,ni,nj);
        }else{
            for(int po=1; po<=9; po++){
                if(validate(board,i,j,po)){
                    board[i][j] = (char)(po+'0');
                    dfs(board,ni,nj);
                    if(!needBacktrace) {
                        board[i][j] = '.';
                    }
                }
            }
        }
    }
    
    public boolean validate(char[][] board, int i, int j, int val) {
        for(int k=0; k<jLen; k++ ){
            if(board[i][k]==(char)(val+'0')) return false;
        }
        
        for(int k=0;k<iLen;k++) {
            if(board[k][j]==(char)(val+'0')) return false;
        }
        
        int si = 3*(i/3);
        int sj = 3*(j/3);
        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                if(board[si+x][sj+y]==(char)(val+'0')) return false;
            }
        }
        return true;
    }

}
