package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SUM_4 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int result = 0;

        if (A.length == 0) return result;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }


        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int sum = (C[i] + D[j]);
                result += map.getOrDefault(-1 * sum, 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {0};
        int B[] = {0};
        int C[] = {0};
        int D[] = {0};
        System.out.println(new SUM_4().fourSumCount(A,B,C,D));

    }
}
