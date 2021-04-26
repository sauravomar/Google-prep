package main.leetcode;

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int maxProd = 1;
        int prod = 1;
        int maxNumber = 0;

        for(int i=0; i<nums.length;i++){
            if(maxProd < nums[i]) maxProd =nums[i];
            prod =  prod * nums[i];
            if(nums[i] > maxNumber)maxNumber= nums[i];
            if(maxProd < prod) maxProd =  prod;
        }

        if(maxNumber == 0 && prod == 0) return 0;

        if(maxProd < prod) maxProd =  prod;
        return maxProd;
    }

    public static void main(String[] args) {
        int arr [] = {-2,0,-1};
        System.out.println(new MaxProductSubarray().maxProduct(arr));
    }
}
