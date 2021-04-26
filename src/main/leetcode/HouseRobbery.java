package main.leetcode;

public class HouseRobbery {

    public int rob(int[] nums) {

        int totalSum = 0;
        if(nums.length == 0 ) return totalSum;
        else if (nums.length == 1)
            return nums[0];
        else
            return Math.max(robRange(nums, 0, nums.length - 2),
                    robRange(nums, 1, nums.length -1));
    }

    private int robRange(int[] num, int start, int end){
        int with = num[start];
        int without = 0;
        for (int i = start + 1; i <= end; i ++){
            int newWith = without + num[i];
            int newWithout = Math.max(with, without);
            with = newWith;
            without = newWithout;
        }
        return Math.max(with, without);
    }
}
