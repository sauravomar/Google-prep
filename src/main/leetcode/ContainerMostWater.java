package main.leetcode;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        if (height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;

        int area = 0;

        while (left < right) {

            area = Math.max(area, Math.min(height[left],
                    height[right]) * (right - left));


            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return area;
    }

    public static void main(String[] args) {

    }
}
