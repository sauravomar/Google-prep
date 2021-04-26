package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RemovedCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        int count = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for(int i=1;i<intervals.length; i++){

            if(intervals[i-1][0] <= intervals[i][0] && intervals[i-1][1] >= intervals[i][1] ){

                int start = intervals[i-1][0];
                int end =  intervals[i-1][1];

                while( i<intervals.length  && start <= intervals[i][0] && end >= intervals[i][1] ){
                    i++;
                    count++;
                }

            } else if(intervals[i-1][0] == intervals[i][0] && intervals[i-1][1] <= intervals[i][1]){
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int intervals [][] = {{1,2},{1,4}, {3,4}};
        System.out.println(new RemovedCoveredIntervals().removeCoveredIntervals(intervals));

    }
}
