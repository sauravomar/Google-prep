package main.hackerrank;

public class Salutes {

    public static int num_salutes(String hallway) {

        if (hallway == null || hallway.length() == 0) return 0;

        char left = '>';
        char right = '<';

        int leftCount = 0;
        int rightCount = 0;

        int totalSalutes = 0;

        for (char ch : hallway.toCharArray()) {
            if (ch == left) leftCount++;
            if (ch == right) rightCount++;
        }


        for (char ch : hallway.toCharArray()) {
            if (ch == left) {
                totalSalutes = totalSalutes + 2 * rightCount;
            } else if (ch == right) {
                rightCount--;
            }
        }
        return totalSalutes;
    }

    public static void main(String[] args) {
        System.out.println(Salutes.num_salutes("--->-><-><-->-"));
    }
}
