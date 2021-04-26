package main.leetcode;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        reverse(nums, nums.length-k,nums.length-1);
        reverse(nums, 0,nums.length-k-1);
        reverse(nums, 0,nums.length-1);
    }

    void reverse(int A[], int low, int high)
    {
        for (int i = low, j = high; i < j; i++, j--)
        {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        new RotateArray().rotate(nums,3);
        Arrays.stream(nums).forEach(value -> System.out.println(value));
    }

}
