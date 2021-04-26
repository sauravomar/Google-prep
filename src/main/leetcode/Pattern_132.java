package main.leetcode;

import java.util.Stack;

public class Pattern_132 {

    public boolean find132pattern(int[] nums) {

        if (nums.length < 3) return false;


        int s3 = Integer.MIN_VALUE;

        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3)
                return true;
            else {
                while (!s.empty() && nums[i] > s.peek()) {
                    s3 = Math.max(s3, s.peek());
                    s.pop();
                }
            }
            s.push(nums[i]);
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, -4, -3};

        System.out.println(new Pattern_132().find132pattern(nums));
    }
}
