package main.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        String strArray[] = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Collections.sort(Arrays.asList(strArray), new Comparator<String>(){

            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY=X + Y;

                // then append X at the end of Y
                String YX=Y + X;

                // Now see which of the two formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1:1;
            }

        });

        if(strArray[0].equals("0")) return "0";

        return String.join("", strArray);

    }

    public static void main(String[] args) {
        int arr[] = {0,0};
        System.out.println(new LargestNumber().largestNumber(arr));
    }
}
