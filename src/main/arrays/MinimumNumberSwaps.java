package main.arrays;

public class MinimumNumberSwaps {

    int minSwap(int arr[], int k) {

        if (arr.length == 0 || k == 0) return 0;

        int min = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) min++;
        }

        int bad = 0;


        for (int i = 0; i < min; i++) {
            if (arr[i] > k) {
                bad ++;
            }
        }

        int ans = bad;

        int i=0;
        int j= min;


        while(i< j && j <arr.length){

            if(arr[i] > k){
                bad--;
            }


            if(arr[j] > k){
                bad++;
            }
            i++;
            j++;

            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
        System.out.print(new MinimumNumberSwaps().minSwap(arr,3) + "\n");
    }

}
