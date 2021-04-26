package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<List<Integer>> result = new ArrayList<>();

        int start =0;
        int end = 0;

        if((intervals[0][0] > newInterval[0] && intervals[0][1]  > newInterval[1])){
            List<Integer> interval = new ArrayList<>();
            interval.add(newInterval[0]);
            interval.add(newInterval[1]);
            result.add(interval);

        }

        for(int i=1; i<intervals.length; i++){


            if((intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) || (intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1])){

                start = intervals[i][0];

                if(intervals[i][0] < newInterval[0]) start = intervals[i][0];
                else start = newInterval[0];

                if(intervals[i][1] > newInterval[1]) end = intervals[i][1];
                else end = newInterval[1];

                int startLoop =  i+1;

                while( (startLoop < intervals.length) && end >= intervals[startLoop][0]){
                   startLoop++;
                }

                if(startLoop > i+1){
                    end = intervals[startLoop-1][1];
                    i=startLoop-1;
                }

            }else{
                start = intervals[i][0];
                end = intervals[i][1];
            }



            List<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            result.add(interval);
        }

        if((result.get(result.size()-1).get(1) < newInterval[0]) || (result.get(0).get(0) > newInterval[0] && result.get(0).get(1) > newInterval[1])){
            List<Integer> interval = new ArrayList<>();
            interval.add(newInterval[0]);
            interval.add(newInterval[1]);
            result.add(interval);

        }

        int[][] overlapped = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            overlapped[i]  =  row.stream().mapToInt(j->j).toArray();
        }
        return  overlapped;
    }

    public static void main(String[] args) {
      int intervals[][] = {{1,5}};
      int  newInterval[] = {0,0};

      intervals = new InsertInterval().insert(intervals, newInterval);

      System.out.println(intervals);
    }
}
