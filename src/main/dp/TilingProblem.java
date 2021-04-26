package main.dp;

public class TilingProblem {

    public int numberWays(int n) {

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if(n == 2) return 2;
        else if (n > 2) {
            return numberWays(n-1) + numberWays(n-2);
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new TilingProblem().numberWays(3));
    }
}
