package main.leetcode;

public class SubProductArray {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(nums.length == 0) return 0;

        int count = 0;

        int start = 0;
        int counter = 1;
        int prod = nums[0];

        if(nums[counter] < k){
            count++;
        }

        while(counter < nums.length){
            while(counter < nums.length && prod < k){
                if(nums[counter] < k){
                    count++;
                }
                prod = nums[counter] * prod;
                count++;
                counter++;
            }
            int pos = start;
            while(pos< nums.length && prod >= k){
                prod = prod/nums[pos];
                pos++;
            }

            start = pos;
        }

        if(prod < k && start < nums.length-1){
            count = count+ nums.length-2 - start;
        }

        return count;
    }

    public static void main(String[] args) {
       int[] nums = {10, 5, 2, 6};
       int k = 100;
       System.out.println(new SubProductArray().numSubarrayProductLessThanK(nums,k));
    }
}
