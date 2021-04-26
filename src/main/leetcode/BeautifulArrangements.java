package main.leetcode;

public class BeautifulArrangements {


    int result = 0;

    public int countArrangement(int n) {

        int nums[] = new int[n + 1];
        dfs(nums, 1, n);
        return result;
    }

    private void dfs(int nums[], int val, int n) {

        if (val > n) {
            result++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0 && (val % i == 0 || i % val == 0)) {
                nums[i] = val;
                dfs(nums, val + 1, n);
                nums[i] = 0;
            }
        }
    }
}
