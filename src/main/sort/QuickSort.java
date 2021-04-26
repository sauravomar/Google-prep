package main.sort;

public class QuickSort {


    public void swap(int arr[], int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    public void quickSort(int arr[], int left, int right) {

        if (left < right) {
            int pivot = partition(arr, left, right);
            System.out.println("left" + left + " right " + right + " pivot " + pivot);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();

        int arr[] = {10, 20, 30, 40, 50, 60, 70};

        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

}
