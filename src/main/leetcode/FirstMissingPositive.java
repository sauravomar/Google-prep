package main.leetcode;

public class FirstMissingPositive {

    private int segregate(int arr[])
    {
        int j = 0, i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    private int findMissing(int arr[], int size)
    {
        int i;

        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1; // 1 is added becuase indexes
        // start from 0

        return size + 1;
    }

    public int firstMissingPositive(int nums[])
    {
        int shift = segregate(nums);
        int arr2[] = new int[nums.length - shift];
        int j = 0;
        for (int i = shift; i < nums.length; i++) {
            arr2[j] = nums[i];
            j++;
        }
        return findMissing(arr2, j);
    }

    public static void main(String[] args) {
        int arr [] = {1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
    }
}
