package main.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

    public void printJumpingNo(int no) {
        for (int i = 1; i < 9; i++) {
            print(i, no);
        }
    }

    private void print(int no, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(no);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num <= x) {
                System.out.println(num);
                int last_digit = num % 10;

                if (last_digit == 0) {
                    queue.add((num * 10) + last_digit + 1);
                } else if (last_digit == 9) {
                    queue.add((num * 10) + last_digit - 1);
                } else {
                    queue.add((num * 10) + last_digit - 1);
                    queue.add((num * 10) + last_digit + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new JumpingNumbers().printJumpingNo(105);
    }
}
