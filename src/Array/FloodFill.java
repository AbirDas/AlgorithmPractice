package Array;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill ff = new FloodFill();
		System.out.println(ff.floodFill(new int[][] {{0,0,0},{0,1,1}}, 1, 1, 1));
		
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        recursive(image,sr,sc,oldColor,newColor,visited);
        return image;
    }
    
    public void recursive(int[][] image, int sr, int sc,int oldColor,int newColor,boolean[][] visited) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc] != oldColor || visited[sr][sc]) return;
        
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        recursive(image,sr-1,sc,oldColor,newColor,visited);
        recursive(image,sr+1,sc,oldColor,newColor,visited);
        recursive(image,sr,sc-1,oldColor,newColor,visited);
        recursive(image,sr,sc+1,oldColor,newColor,visited);
    }

}
