package main.leetcode;

import java.util.Stack;

public class MostCompetiitiveSubSeq {

    public int[] mostCompetitive(int[] nums, int k) {
        int result[] = new int[k];

        int rem = nums.length - k;
        int index = k - 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && rem > 0 && nums[i] < stack.peek()) {
                stack.pop();
                rem--;
            }
            stack.push(nums[i]);
        }

        while (rem > 0) {
            stack.pop();
            rem--;
        }

        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3,5,2,6};
        System.out.println(new MostCompetiitiveSubSeq().mostCompetitive(nums, 2));
    }
}
