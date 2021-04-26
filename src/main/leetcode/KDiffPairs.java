package main.leetcode;

import java.util.Arrays;

public class KDiffPairs {

    public int findPairs(int[] nums, int k) {
        int count = 0;

        Arrays.sort(nums);

        int start = 0;
        int end = 0;


        while(start < nums.length)
        {
            if(start != end && nums[start] - nums[end] == k)
            {
                count++;
                start++;
                end++;

                while(start < nums.length && nums[start] == nums[start-1]) start++;
                while(end < nums.length && nums[end] == nums[end-1]) end++;
            }
            else if(nums[start] - nums[end] > k)
                end++;
            else
                start++;
        }

        return count;
    }

    public static void main(String[] args) {
       int [] nums = {-1,-2,-3};
       int k = 1;

       System.out.println(new KDiffPairs().findPairs(nums, k));
    }
}
