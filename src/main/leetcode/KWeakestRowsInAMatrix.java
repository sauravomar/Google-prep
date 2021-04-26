package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KWeakestRowsInAMatrix {

    class Row {
        int rowNo;
        int count;

        public Row(int rowNo, int count) {
            this.rowNo = rowNo;
            this.count = count;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        if (k == 0 || mat.length == 0) return new int[0];

        Row[] rows = new Row[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            rows[i] = new Row(i, count);
        }

        Arrays.sort(rows, new Comparator<Row>() {
            @Override
            public int compare(Row first, Row second) {
                return first.count - second.count;
            }
        });
        int[] result = new int[k];


        for (int i = 0; i < k; i++) {
            result[i] = rows[i].rowNo;
        }
        return result;

    }
}
