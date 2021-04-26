package main.leetcode;

public class MaxIandJ {

    int maxDiff(int arr[]){
        if(arr.length == 0) return 0;


        int leftMin[] = new int[arr.length];
        int rightMax[] = new int[arr.length];

        leftMin[0] = arr[0];
        rightMax[arr.length-1]=  arr[arr.length-1];

        for(int i=1; i<arr.length; i++){
            if(arr[i] < leftMin[i-1]){
                leftMin[i] = arr[i];
            }else{
                leftMin[i] = leftMin[i-1];
            }
        }

        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > rightMax[i+1]){
                rightMax[i] = arr[i];
            }else{
                rightMax[i] = rightMax[i+1];
            }
        }


        int i =0;
        int j = 0;

        int diff = -1;

        while( i < arr.length && j< arr.length){

            if(leftMin[i] < rightMax[j]){
                diff =  Math.max(diff, j-i);
                j++;
            }else{
                i++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new MaxIandJ().maxDiff(arr));
    }

}
