package main.leetcode;

public class CheckAllOnesKDist {

    public boolean kLengthApart(int[] nums, int k) {

        if (nums.length == 0) return true;

        int currentDistance = 0;
        boolean isFirstOne = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                if (isFirstOne) {
                    isFirstOne = false;
                    continue;
                } else {
                    if (currentDistance < k) return false;
                    currentDistance = 0;
                }
            } else {
                currentDistance++;
            }

        }



        return true;

    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,1};

        System.out.println(new CheckAllOnesKDist().kLengthApart(arr, 1));
    }
}
