package main.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvanceShuffle {
    public int[] advantageCount(int[] A, int[] B) {

        int result[] = new int[A.length];

        Arrays.sort(A);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < B.length; i++) {
            pq.offer(new int[]{i, B[i]});
        }


        int slow = 0;
        int fast = A.length - 1;

        while (!pq.isEmpty()) {
            int b[] = pq.poll();
            result[b[0]] =  b[1] >=A[fast] ? A[slow++]: A[fast--];
        }
        return result;
    }

}
