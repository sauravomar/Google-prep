package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactor {

    public int numFactoredBinaryTrees(int[] arr) {

        double res = 0.0, mod = (long) 1e9 + 7;

        Arrays.sort(arr);

        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], 1.0);

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    map.put(arr[i], map.get(arr[i]) + map.get(arr[j]) * map.getOrDefault(arr[i] / arr[j], 1.0) % mod);
                }
            }

            res = res + map.get(arr[i]) % mod;
        }

        return (int) res;

    }

    public static void main(String[] args) {
        int arr[] = {15, 13, 22, 7, 11};
        System.out.println(new BinaryTreeWithFactor().numFactoredBinaryTrees(arr));
    }

}
