package main.leetcode;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) return 0;

        if (nums.length == 1) return 1;

        int start = 1;

        int isGreater = 0;
        int number = 1;

        while (start < nums.length) {
            if (isGreater == 1 && nums[start - 1] < nums[start]) {
                number++;
                isGreater = 2;
            } else if (isGreater == 2 && nums[start - 1] > nums[start]) {
                number++;
                isGreater = 1;
            } else if (isGreater == 0) {
                if (nums[start - 1] > nums[start]) {
                    isGreater = 1;
                    number++;
                } else if (nums[start - 1] < nums[start]) {
                    isGreater = 2;
                    number++;
                }
            }
            start++;
        }


        return number;
    }

    public static void main(String[] args) {
        int nums[] = {3, 3, 3, 2, 5};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }
}
