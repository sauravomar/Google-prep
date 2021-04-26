package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();

        if (nums.length == 0) return list;
        StringBuilder sb = new StringBuilder();

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (start == nums[i] || end == nums[i]) {
                continue;
            }else if( start == nums[i] -1 || end == nums[i] -1 ){
                end = nums[i];
            }
            else if (start == end) {
                sb.append(start);
                list.add(sb.toString());
                sb.setLength(0);
                start =  nums[i];
                end = nums[i];
            } else {
                sb.append(start);
                sb.append("->");
                sb.append(end);
                list.add(sb.toString());
                sb.setLength(0);
                start = nums[i];
                end = nums[i];
            }
        }

        if (start != end){
            sb.append(start);
            sb.append("->");
            sb.append(end);
            list.add(sb.toString());
        }else if(start == end){
            sb.append(start);
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }
}
