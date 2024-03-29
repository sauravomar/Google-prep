package main.leetcode;

public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] tower = new double[101][101];
        tower[0][0] = poured;


        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {

                double leftChampagne = (tower[row][col] - 1) / 2.0;
                if (leftChampagne > 0) {
                    tower[row + 1][col] += leftChampagne;
                    tower[row + 1][col + 1] += leftChampagne;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }

    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTower(100000009, 33, 17));
    }

}
