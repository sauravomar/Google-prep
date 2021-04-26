package main.leetcode;

import java.util.Arrays;

public class KthLargestArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {

        int arr[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new KthLargestArray().findKthLargest(arr, 4));
    }

}
