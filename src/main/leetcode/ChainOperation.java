package main.leetcode;

public class ChainOperation {

    public int solution(int[] A) {
        if (A.length == 0) return 0;

        int start = 0;
        int end = A.length - 1;

        int sum = Integer.MAX_VALUE;

        while (start < end) {
            if (A[start] < A[end] && A[start] + A[end] < sum) sum = A[start] + A[end];

            if (A[start] > A[end]) {
                start++;
            } else {
                end--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 4, 6, 3, 7};
        System.out.println(new ChainOperation().solution(arr));
    }
}
