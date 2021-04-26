package main.leetcode;

import java.util.List;

public class SortedArrayCost {

    static int[][] dp = new int[1000][1000];


    static int minRemove(int arr[], int n)
    {
        int LIS[] = new int[n];
        int len = 0;

        // Mark all elements of LIS as 1
        for (int i = 0; i < n; i++)
            LIS[i] = 1;

        // Find LIS of array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (i-j)<=(arr[i]-arr[j]))
                    LIS[i] = Math.max(LIS[i],
                            LIS[j] + 1);
            }
            len = Math.max(len, LIS[i]);
        }

        // Return min changes for array
        // to strictly increasing
        return n - len;
    }


    public static long modifyArray(List<Integer> arr) {
        // Write your code here

        int cost_1 = 0;
        int cost_2 = 0;

        int ascCount = 0;
        int descCount = 0;

        if (arr.size() <= 2) return 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                int currNumber = arr.get(i);
                if (i >= 1 && i < arr.size() - 1) {
                    cost_1 = cost_1 + Math.min(Math.abs(currNumber - arr.get(i - 1)), Math.abs(currNumber - arr.get(i + 1)));
                } else if (i == arr.size() - 1) {
                    cost_1 = cost_1 + Math.abs(currNumber - arr.get(i - 1));
                }
                System.out.println(i + " cost " + cost_1);
            }
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) < arr.get(i + 1)) {
                int currNumber = arr.get(i);
                if (i >= 1 && i < arr.size() - 1) {
                    cost_2 = cost_2 + Math.min(Math.abs(currNumber - arr.get(i - 1)), Math.abs(currNumber - arr.get(i + 1)));
                } else if (i == arr.size() - 1) {
                    cost_2 = cost_2 + Math.abs(currNumber - arr.get(i - 1));
                }
                System.out.println(i + " cost " + cost_2);
            }
        }


        return Math.min(cost_1, cost_2);
    }

    public static void main(String[] args) {
        int arr[] = {9847,
                3752,
                5621,
                7012,
                1986,
                3090,
                1383,
                6257,
                9501,
                7004,
                6181,
                9387,
                9137,
                9305,
                7795,
                9310,
                3904,
                8328,
                6656,
                8123,
                1796,
                2754,
                4372,
                5200,
                3893,
                8568,
                4436,
                3973,
                8498,
                1879,
                2731,
                4651,
                4388,
                453,
                2465,
                2669,
                6384,
                819,
                8565,
                1952,
                7219,
                4362,
                3012,
                9380,
                2645,
                4800,
                2945,
                5778,
                1993,
                1170,
                1356,
                8557,
                1497,
                8921,
                670,
                5155,
                9115,
                1095,
                9400,
                9451,
                9344,
                4393,
                4201,
                8167,
                8129,
                2004,
                8839,
                1457,
                7682,
                1881,
                9266,
                6366,
                9889,
                242,
                5318,
                5248,
                3670,
                7381,
                6567,
                2317,
                2162,
                6670,
                5876,
                1179,
                2482,
                9270,
                4326,
                4166,
                6122,
                2016,
                3008,
                5349,
                1723,
                5816,
                4030};


        System.out.println(minRemove(arr, arr.length));
    }

}
