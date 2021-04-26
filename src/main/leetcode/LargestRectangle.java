package main.leetcode;

import java.util.Stack;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) return 0;
        int result = 0;

        int area = 0;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        int iterator = 0;

        while (iterator < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[iterator]) {
                stack.push(iterator++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * iterator;
                } else {
                    area = heights[top] * (iterator - stack.peek() - 1);
                }

                if (maxArea < area) maxArea = area;
            }
        }

        while (!stack.isEmpty()) {
            int top =  stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * iterator;
            } else {
                area = heights[top] * (iterator - stack.peek() - 1);
            }

            if (maxArea < area) maxArea = area;

        }

        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(new LargestRectangle().largestRectangleArea(heights));
    }
}
