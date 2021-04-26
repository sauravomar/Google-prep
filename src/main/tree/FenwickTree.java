package main.tree;

public class FenwickTree {
    private int arr[];

    public int getSum(int i) {

        int sum = 0;
        int index = i+1;
        while (index > 0) {
            sum += this.arr[index];
            index = index - (index & -index);
        }

        return sum;

    }

    public void update(int i, int x) {

        int index = i+1;
        while (index < this.arr.length) {
            this.arr[index] += x;
            index = index + (index & -index);
        }

    }

    public static void main(String[] args) {

        FenwickTree tree = new FenwickTree();
        int array[] = {1, 3, 3, 3, 2, 4, 2, 1, 2};
        tree.arr = new int[array.length+1];

        for(int i=0; i<array.length; i++){
            tree.update(i, array[i]);
        }

        System.out.println(tree.getSum(4));

    }
}
