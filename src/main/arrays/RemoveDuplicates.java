package main.arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return  0;

        int number = nums[0];
        int count=1;

        for(int i=0; i<nums.length ; i++){
            if(nums[i] == number){
                continue;
            }

            nums[count-1] = number;
            number = nums[i];
            count++;
        }

        nums[count-1] = number;
        return  count;
    }

    public int removeDuplicates_2(int[] nums) {
        if(nums.length == 0) return  0;

        int number = nums[0];
        int countEven = 1;
        int count=1;

        for(int i=0; i<nums.length ; i++){
            if(nums[i] == number){
                countEven++;
                continue;
            }

            if(countEven >= 2){
                nums[count-1] = number;
                count++;
                countEven = 1;
            }

            nums[count-1] = number;
            number = nums[i];
            count++;
        }

        nums[count-1] = number;
        return  count;
    }

    public static void main(String[] args) {
        int arr[] ={1,1,1,2,2,3,3};
        System.out.println(new RemoveDuplicates().removeDuplicates_2(arr));
        System.out.println(arr);
    }

}
