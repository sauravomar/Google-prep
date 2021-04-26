package main.leetcode;

public class SortedArrayThroughInstructtion {

    private int arr[];
    int high = 100000;

    void add(int x) {
        while (x <= high) {
            arr[x]++;
            x += x & (-x);
        }
    }

    int q(int x) {
        if (x == 0) return x;
        int ret = 0;
        while (x > 0) {
            ret += arr[x];
            x -= x & (-x);
        }
        return ret;
    }

    public int createSortedArray(int[] instructions) {
        arr = new int[high + 1];
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < instructions.length; i++) {
            add(instructions[i]);
            int left = q(instructions[i] - 1);
            int right = i + 1 - q(instructions[i]);
            sum = (sum + Math.min(left, right) % mod) % mod;
        }
        return sum;
    }
}
