package Google.Medium;

public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		/*
		Input: image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2
		Output: 6
		*/
		char[][] image = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
		System.out.println(minArea(image,0,2));
	}

	static int top, bottom, left, right;

	public static int minArea(char[][] image, int x, int y) {
		if (image.length == 0 || image[0].length == 0)
			return 0;
		
		top = bottom = x;
		left = right = y;
		dfs(image, x, y);
		return (bottom - top) * (right - left);
	}

	private static void dfs(char[][] image, int x, int y) {
		if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0')
			return;
		
		image[x][y] = '0';
		top = Math.min(top, x);
		bottom = Math.max(bottom, x + 1);
		left = Math.min(left, y);
		right = Math.max(right, y + 1);
		dfs(image, x - 1, y);
		dfs(image, x + 1, y);
		dfs(image, x, y - 1);
		dfs(image, x, y + 1);
	}

}
