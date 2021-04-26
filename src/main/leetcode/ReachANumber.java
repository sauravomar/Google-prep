package main.leetcode;

public class ReachANumber {

    public int reachNumber(int target) {
        return steps(1, 0, target);
    }

    public int steps(int source, int step,
                     int dest) {
        if (Math.abs(source) > (dest))
            return Integer.MAX_VALUE;

        if (source == dest)
            return step;

        int pos = steps(source + step + 1,
                step + 1, dest);

        int neg = steps(source - step - 1,
                step + 1, dest);

        return Math.min(pos, neg);
    }
}
