package main.leetcode;

public class GlobalAndLocalInversion {

    private int arr[];

    public int getSum(int i) {

        int sum = 0;
        int index = i + 1;
        while (index > 0) {
            sum += this.arr[index];
            index = index - (index & -index);
        }

        return sum;

    }

    public void update(int i, int x) {

        int index = i + 1;
        while (index < this.arr.length) {
            this.arr[index] += x;
            index = index + (index & -index);
        }

    }

}
