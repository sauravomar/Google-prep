package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayTransformation {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        int n = arr.length;
        if (n == 0 && pieces.length == 0) return true;
        if (n == 0 && pieces.length > 0) return false;

        Map<Integer, int[]> map = new HashMap<>();

        for (int p[] : pieces) {
            map.put(p[0], p);
        }


        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int p[] = map.get(arr[i]);
                for (int number : p) {
                    if (number == arr[i]) i++;
                    else return false;
                }
                i--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = {91, 4, 64, 78};
        int pieces[][] = {{78}, {4, 64}, {91}};

        System.out.println(new CheckArrayTransformation().canFormArray(arr, pieces));

    }
}
