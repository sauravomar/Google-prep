package main.divideAndConquer;

public class QuickSort {

    public int parition(int arr[], int start, int end) {

        if (start > end) {
            return -1;
        }

        int pivot = arr[end];

        int i = start;
        int j = end;

        while (i < j) {
            while( i < j && arr[i] < pivot)  i++;
            while( i < j && arr[j] > pivot)  j--;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        if(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return j ;
    }


    public void quickSort(int arr[], int start, int end){
        if(start < end){
            int pos = parition(arr, start, end);

            if(pos == -1) return;

            quickSort(arr, start, pos-1);
            quickSort(arr, pos+1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        System.out.println(arr);
    }
}
