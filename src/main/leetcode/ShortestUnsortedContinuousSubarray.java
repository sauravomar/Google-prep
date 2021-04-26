package main.leetcode;

public class ShortestUnsortedContinuousSubarray {


    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;

        int i = 0;

        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }

        if (i == nums.length - 1) return 0;

        int j = 0;

        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                break;
            }
        }


        int max = nums[i];
        int min = nums[i];
        for (int k = i + 1; k <= j; k++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }


        for (int k = 0; k < i; k++) {
            if (nums[i] > min) {
                i = k;
                break;
            }
        }

        // step 2(c) of above algo
        for (int l = nums.length - 1; l >= j + 1; l--) {
            if (nums[l] < max) {
                j = l;
                break;
            }
        }

        return j - i;
    }

    public static void main(String[] args) {

    }
}
