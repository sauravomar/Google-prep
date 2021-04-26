package main.leetcode;

public class BinarySearch {

    public int search(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {-1,0,3,5,9,12};
        int target = 13;
        System.out.println(new BinarySearch().search(nums, target));
    }
}
