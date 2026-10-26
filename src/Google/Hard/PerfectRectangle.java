package Google.Hard;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    public static void main(String[] arg) {
        //leetcode problem 391. Perfect Rectangle
    }

    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles==null) return false;

        int len = rectangles.length;
        if(len==1) return true;
        int xmin = Integer.MAX_VALUE , ymin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE , ymax = Integer.MIN_VALUE;
        long totalArea = 0;
        Set<String> rectCor = new HashSet<String>();

        for(int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            xmin = Math.min(xmin, x1);
            ymin = Math.min(ymin, y1);
            xmax = Math.max(xmax, x2);
            ymax = Math.max(ymax, y2);

            totalArea += (x2-x1) * (y2-y1);

            String[] allCor = new String[4];
            allCor[0] = x1 + "," + y1;
            allCor[1] = x1 + "," + y2;
            allCor[2] = x2 + "," + y1;
            allCor[3] = x2 + "," + y2;

            for (String cor : allCor) {
                if (rectCor.contains(cor)) {
                    rectCor.remove(cor);
                } else {
                    rectCor.add(cor);
                }
            }

        }

        long area = (xmax-xmin) * (ymax-ymin);
        if(totalArea != area)
            return false;

        if(rectCor.size()!=4 || !rectCor.contains(xmin+","+ymin) || !rectCor.contains(xmin+","+ymax) || !rectCor.contains(xmax+","+ymin) || !rectCor.contains(xmax+","+ymax))
            return false;

        return true;
    }

    /*public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        long totalArea = 0;

        HashSet<String> cornerSet = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1];
            int x2 = rect[2], y2 = rect[3];
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            totalArea += (long) (x2 - x1) * (y2 - y1);
            String[] corners = {
                    x1 + "," + y1, x1 + "," + y2,
                    x2 + "," + y1, x2 + "," + y2
            };

            for (String corner : corners) {
                if (!cornerSet.add(corner)) {
                    cornerSet.remove(corner);
                }
            }
        }
        long boundingArea = (long) (maxX - minX) * (maxY - minY);
        if (totalArea != boundingArea) return false;

        if (cornerSet.size() != 4 ||
                !cornerSet.contains(minX + "," + minY) ||
                !cornerSet.contains(minX + "," + maxY) ||
                !cornerSet.contains(maxX + "," + minY) ||
                !cornerSet.contains(maxX + "," + maxY)) {
            return false;
        }

        return true;
    }*/
}
