package main.leetcode;

public class SearchInRotatedArray {

    public int binarySearch(int arr[], int low, int high, int key) {

        if (high < low) return -1;

        int mid = (high + low) / 2;

        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) {
            if (arr[low] <= key) return binarySearch(arr, low, mid - 1, key);
            else return binarySearch(arr, mid + 1, high, key);
        } else {
            if (arr[high] < key) return binarySearch(arr, low, mid - 1, key);
            else return binarySearch(arr, mid + 1, high, key);
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1, 2};

        System.out.println(new SearchInRotatedArray().binarySearch(arr, 0, arr.length-1, 2));
     }
}
