package Google.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class IMP_EarliestMomentWhenEveryoneBecomeFriends {

    // Union-Find or Disjoint Set Union(DSU)

    public static void main(String[] src) {
        //Leet code 1101 problem
        int[][] logs = {
            {20190101, 0, 1},
            {20190104, 3, 4},
            {20190107, 2, 3},
            {20190211, 1, 5},
            {20190224, 2, 4},
            {20190301, 0, 3},
            {20190312, 1, 2},
            {20190322, 4, 5}
        };
        int ans = earliestAcq(logs,6);
        System.out.println(ans);
    }

    public static int earliestAcq(int[][] logs, int n) {
        if(logs==null) return -1;
        int len = logs.length;
        int[] root = new int[n];

        for(int i=0; i<n; i++) {
            root[i] = i;
        }

        /* old java way
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0],b[0]);
            }
        });*/

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        for(int i=0; i<len; i++) {
            int rootx = findRoot(logs[i][1], root);
            int rooty = findRoot(logs[i][2], root);

            if(rootx!=rooty) {
                if(rootx<rooty) {
                    root[rooty] = rootx;
                } else {
                    root[rootx] = rooty;
                }
                n--;
            }

            if(n==1) {
                return logs[i][0];
            }
        }

        if(n==0) {
            return logs[len-1][0];
        }

        return -1;
    }

    private static int findRoot(int num, int[] root) {
        while(num!=root[num]) {
            root[num] = root[root[num]];
            num = root[num];
        }
        return num;
    }
}
