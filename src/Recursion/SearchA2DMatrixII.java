package Recursion;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
		//Output: false
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        
        if(matrix[0][0] > target || matrix[row][col] < target) return false;
        
        int min = Math.min(row,col);
        
        for(int i=0; i<=min; i++) {
            boolean vertical = binarySearch(matrix,target,i,true);
            boolean horizontal = binarySearch(matrix,target,i,false);
            if(vertical || horizontal) {
                return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[][] matrix, int target, int start, boolean direction){
        
        int lo = start;
        int hi = direction ? matrix.length-1 : matrix[0].length-1;
        
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            //vertival
            if(direction) {
                if(matrix[mid][start] < target) {
                    lo = mid +1;
                } else if(matrix[mid][start] > target) {
                    hi = mid -1;
                } else {
                    return true;
                }
            }else{
                //horizontal
                if(matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if(matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
