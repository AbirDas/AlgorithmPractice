package Google.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMP_DetectSquares {

    public static void main(String[] arg) {
        /**
         * Leetcode 2013 Detect Squares
         * Your DetectSquares object will be instantiated and called as such:
         * DetectSquares obj = new DetectSquares();
         * obj.add(point);
         * int param_2 = obj.count(point);
         */
        IMP_DetectSquares ds = new IMP_DetectSquares();

    }

    List<int[]> list;
    Map<String, Integer> countMap;

    public IMP_DetectSquares() {
        list = new ArrayList<>();
        countMap = new HashMap<>();
    }

    public void add(int[] point) {
        String s = point[0] + "," + point[1];
        if (countMap.containsKey(s)) {
            countMap.put(s, countMap.get(s) + 1);
        } else {
            countMap.put(s, 1);
            list.add(point);
        }
    }

    public int count(int[] point) {

        int currentX = point[0];
        int currentY = point[1];
        int result = 0;

        for (int[] p : list) {
            if (p[0] != currentX && p[1] != currentY
                    && Math.abs(p[0] - currentX) == Math.abs(p[1] - currentY)) {

                String otherPoint1 = currentX + "," + p[1];
                String otherPoint2 = p[0] + "," + currentY;
                String currentPoint = p[0] + "," + p[1];

                result += countMap.getOrDefault(otherPoint1, 0)
                        * countMap.getOrDefault(otherPoint2, 0)
                        * countMap.getOrDefault(currentPoint, 0);
            }
        }
        return result;
    }


}
