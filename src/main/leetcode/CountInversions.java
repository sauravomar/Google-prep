package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static long howManySwaps(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return 0;
        return mergeSortCount(arr, 0, arr.size() - 1);

    }

    private static long mergeCount(List<Integer> arr, int start, int mid, int end) {

        List<Integer> left = new ArrayList<>(arr.subList(start, mid + 1));
        List<Integer> right = new ArrayList<>(arr.subList(mid + 1, end + 1));

        int leftIndex = 0;
        int rightIndex = 0;
        long swaps = 0;
        int index = start;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                arr.set(index++, left.get(leftIndex++));
            } else {
                arr.set(index++, right.get(rightIndex++));
                swaps = swaps + ((mid + 1) - (start + leftIndex));
            }
        }

        while (leftIndex < left.size()) {
            arr.set(index++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            arr.set(index++, right.get(rightIndex++));
        }


        return swaps;

    }

    private static long mergeSortCount(List<Integer> arr, int start, int end) {

        long swaps = 0;
        if (start < end) {

            int mid = (start + end) / 2;
            swaps = swaps + mergeSortCount(arr, start, mid);
            swaps = swaps + mergeSortCount(arr, mid + 1, end);
            swaps = swaps + mergeCount(arr, start, mid, end);

        }

        return swaps;

    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(7);
        list.add(1);
        list.add(2);


        System.out.println(CountInversions.howManySwaps(list));
    }
}
