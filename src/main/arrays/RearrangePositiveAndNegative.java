package main.arrays;

public class RearrangePositiveAndNegative {

    public int [] rearrange(int arr[]) {

        if(arr.length == 0) return arr;

        int start = 0;
        int iterator = 0;


        while(start < arr.length && iterator < arr.length){
            while(start < arr.length  && arr[start] < 0) {
                start++;
            }

            iterator = start;
            while(iterator < arr.length && arr[iterator] > 0 ) {
                iterator++;
            }

            if(start < arr.length  && iterator < arr.length){
                int temp = arr[start];
                arr[start] = arr[iterator];
                arr[iterator] = temp;
                start ++;
                iterator++;
            }
        }

        return arr;

    }

    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, -9};
        System.out.println(new RearrangePositiveAndNegative().rearrange(arr));
    }
}
