package main.leetcode;

public class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 0)
            return 0;

        int value1 = nums[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(nums[0], nums[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(nums[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;

    }

    public static void main(String[] args) {
        int arr[] = {2,7,9,3,1};
        System.out.println(new HouseRobber().rob(arr));
    }
}
