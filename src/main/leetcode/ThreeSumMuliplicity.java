package main.leetcode;

import java.util.Arrays;

public class ThreeSumMuliplicity {


    public int threeSumMulti(int[] arr, int target) {

        int mod = 1000000007;

        if (arr.length == 0) return 0;
        Arrays.sort(arr);

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            int sum = target - arr[i];


            while (j < k) {

                if (arr[j] + arr[k] > sum) {
                    k--;
                } else if (arr[j] + arr[k] < sum) {
                    j++;
                } else {
                    int count1 = 0;
                    int count2 = 0;


                    int start = j;
                    int end = k;

                    while (j <=end && arr[j] == arr[start]) {
                        j++;
                        count1++;
                    }


                    if (j > end) {
                        int res = count1 * (count1 - 1) / 2;
                        result = (result + res) % mod;
                    } else {
                        while (k >= start && arr[k] == arr[end]) {
                            k--;
                            count2++;
                        }
                        int res = (count1 * count2) % mod;
                        result = (result + res) % mod;

                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2};
        System.out.println(new ThreeSumMuliplicity().threeSumMulti(arr, 5));
    }
}
