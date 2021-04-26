package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxKSum {

    public int maxOperations(int[] nums, int k) {

        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v < k) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }


        for (int key : map.keySet()) {
            max += Math.min(
                    map.getOrDefault(key, 0),
                    map.getOrDefault(k - key, 0));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        System.out.println(new MaxKSum().maxOperations(num, 2));
    }
}
