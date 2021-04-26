package main.arrays;

public class FirstMissingPositive {

    public int findMissing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (x - 1 < nums.length && nums[x - 1] > 0)
                nums[x - 1] = -nums[x - 1];
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                return i + 1; // 1 is added becuase indexes
        // start from 0

        return nums.length + 1;
    }

    public int firstMissingPositive(int arr[])
    {
        int shift = seaggregate(arr);
        int arr2[] = new int[arr.length - shift];
        int j = 0;
        for (int i = shift; i < arr.length; i++) {
            arr2[j] = arr[i];
            j++;
        }
        return findMissing(arr2);
    }

    public int seaggregate(int []nums){

        int j = 0;

        for(int i=0; i<nums.length;i++) {
            if (nums[i] <0) {
                int temp;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;

    }
}
