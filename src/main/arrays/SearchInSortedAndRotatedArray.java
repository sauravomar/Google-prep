package main.arrays;

public class SearchInSortedAndRotatedArray {


    public int binarySearch(int arr[], int key, int start, int end){

        if(arr.length == 0) return -1;

        if (start > end)
            return -1;

        int mid =  (start + end)/2;
        if(arr[mid] == key) return mid;

        if(arr[start] < arr[mid] || start == mid){

            if (key >= arr[start] && key <= arr[mid])
                return binarySearch(arr, key,start, mid - 1);

            return binarySearch(arr, key,mid+1, end);

        }

        if (key >= arr[mid] && key <= arr[end]){
            return binarySearch(arr, key,mid+1, end);
        }

        return binarySearch(arr, key, start,mid-1);
    }

    public static void main(String[] args) {
        int arr[] = {2,5,6,0,0,1,2 };
        int key = 3;

        int i = new SearchInSortedAndRotatedArray().binarySearch(arr, key, 0,arr.length-1);
        System.out.println(i);

    }
}
