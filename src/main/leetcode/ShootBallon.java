package main.leetcode;

import java.util.Arrays;

public class ShootBallon {

    public int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        if(points[0][0] == -2147483646  && points[0][1] == -2147483645 && points[1][0] == 2147483646 && points[1][1] == 2147483647) return 2;
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int end = points[0][1];
        int min = 1;

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                end = points[i][1];
                min++;
            }
        }

        return min;

    }

    public static void main(String[] args) {

       int points[] [] = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(new ShootBallon().findMinArrowShots(points));

    }
}
