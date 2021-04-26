package main.leetcode;

public class PrintAllSeq {


    public void print(int arr[], int sum) {

        if (arr.length == 0) return;

        int index = 0;
        int start = 0;
        int currSum = 0;
        int zeroIndex = 0;

        while (index < arr.length) {

            while (index < arr.length && currSum <= sum) {
                currSum = currSum + arr[index];
                index++;
            }

            int end = index-1;

            while (start <= index - 1 && currSum == sum) {

                if(arr[start] ==0 && arr[end] ==0){
                    System.out.println(start + " " + end);
                    start++;
                    System.out.println(start + " " + end);
                    end--;
                    System.out.println(start + " " + end);
                }

                else if(arr[start] == 0){
                    System.out.println(start + " " + end);
                    start++;
                }

               else if(arr[end] == 0){
                    end--;
                    System.out.println(start + " " + end);
                }

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 0, 0};
        new PrintAllSeq().print(arr, 1);
    }
}
