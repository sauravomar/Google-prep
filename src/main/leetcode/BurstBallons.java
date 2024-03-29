package main.leetcode;

public class BurstBallons {

    public int maxCoins(int[] nums) {

        if (nums.length == 0) return 0;

        int dp[][] = new int[nums.length][nums.length];


        for (int len = 1; len <= nums.length; len++) {

            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {


                    int leftVal = 1;
                    int rightVal = 1;

                    if (i != 0) {
                        leftVal = nums[i - 1];
                    }

                    if (j != nums.length - 1) {
                        rightVal = nums[j + 1];
                    }

                    int before =0;
                    int after = 0;

                    if(i !=k){
                        before = dp[i][k-1];
                    }

                    if(j !=k){
                        after = dp[k+1][j];
                    }

                    dp[i][j] = Math.max(leftVal* nums[k] * rightVal + before+ after, dp[i][j]);

                }
            }
        }


        return dp[0][nums.length - 1];

    }
}

