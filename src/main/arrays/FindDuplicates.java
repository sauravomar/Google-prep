package main.arrays;

public class FindDuplicates {
    public int findDuplicate(int[] nums) {

        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }

        int n=nums.length;
        return sum - ((n-1)*n)/2;
    }
}
