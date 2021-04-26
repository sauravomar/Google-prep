package main.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class JumpGame {

//    public int jump(int[] nums) {
//
//    }


//    public static int ArrayChallenge(int[] arr) {
//
//        int jump = 0, max0 = 0, max1 = 0, i = 0;
//
//        while (max1 < arr.length - 1) {
//
//            for (; i <= max0; i++) {
//                max1 = Math.max(max1, arr[i] + i);
//            }
//
//            if (i == (max0 + 1)) {
//                max0 = max1;
//                jump++;
//            }
//        }
//
//
//        return jump;
//    }


    public static boolean ArrayChallenge(int[] arr) {



        Arrays.sort(arr);


        int maxNum = arr[arr.length-1];

        for (int i = 0; i < arr.length-1; i++) {
            int tot = arr[i];
            for (int j = 0; j < arr.length-1; j++) {
                if (i != j) {
                    tot += arr[j];
                    if (tot == maxNum) {
                        return true;
                    }
                }
            }

            for (int k = 0; k < arr.length-1; k++) {
                if (i != k) {
                    tot -= arr[k];
                    if (tot == maxNum) {
                        return true;
                    }
                }
            }
        }

        return false;

    }


    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, -1, 8, 12};

        System.out.println(ArrayChallenge(arr));
    }
}
