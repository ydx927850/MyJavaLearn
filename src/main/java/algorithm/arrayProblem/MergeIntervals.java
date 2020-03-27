package algorithm.arrayProblem;

import java.util.*;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals){
        if(intervals==null || intervals.length==0){
            return intervals;
        }
        int row = intervals.length;
        int col = 2;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0 || list.getLast()[1] < interval[0]) {
                list.addLast(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        while(!list.isEmpty()){
            res[index++] = list.removeFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,16}
        };
        System.out.println(Arrays.deepToString(mergeIntervals(nums)));
    }
}
