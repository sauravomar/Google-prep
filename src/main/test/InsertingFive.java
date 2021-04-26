package main.test;

import java.util.Collections;
import java.util.Comparator;

public class InsertingFive {

    public int solution(int N) {
        // write your code here
        if (N == 0) {
            return 50;
        }
        Comparator<Integer> comparator = N > 0 ? Integer::compareTo : Collections.reverseOrder(Integer::compareTo);
        StringBuilder builder = new StringBuilder();
        if (N < 0) {
            builder.append('-');
        }
        String s = String.valueOf(Math.abs(N));
        boolean injected = false;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (comparator.compare(5, digit) > 0 && !injected) {
                builder.append(5);
                builder.append(c);
                injected = true;
            } else {
                builder.append(c);
            }
        }
        if (!injected) {
            builder.append(5);
        }
        return Integer.valueOf(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(new InsertingFive().solution(670));
    }
}
