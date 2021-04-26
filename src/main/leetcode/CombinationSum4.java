package main.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CombinationSum4 {

    Set<String> set = new HashSet<>();

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int dp[] = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    dp[i + num] += dp[i];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        CombinationSum4 obj = new CombinationSum4();
        int nums[] = {1, 2, 3, 4};
        System.out.println(obj.combinationSum4(nums, 4));
    }
}
