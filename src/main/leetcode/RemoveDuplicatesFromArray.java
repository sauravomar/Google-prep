package main.leetcode;

public class RemoveDuplicatesFromArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int count = 1;
        int iterator=1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[iterator-1] && nums[i] == nums[i-1]) {
                count++;
                if(count <3){
                    nums[iterator] = nums[i];
                    iterator++;
                }
                continue;
            }
            else count = 1;
            nums[iterator] = nums[i];
            iterator++;
        }
        return iterator;
    }

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,2,2,4};

        System.out.println(new RemoveDuplicatesFromArray().removeDuplicates(nums));

    }
}
