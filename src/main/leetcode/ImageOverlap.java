package main.leetcode;

public class ImageOverlap {

    int largestOverlap(int[][] A, int[][] B) {
        return Math.max(helper(A, B), helper(B, A));
    }

   private int helper( int[][] A, int[][] B){
        int overlap = 0;
        int n = A.length;
        for(int x = 0; x < n; ++x){
            for(int y = 0; y < n; ++y){
                int count = 0;
                for(int ia = 0, ib = x; ib < n; ++ia, ++ib){
                    for(int ja = 0, jb = y; jb < n; ++ja, ++jb){

                        System.out.println(A[ia][ja]  + " " +   B[ib][jb]);
                        count += (A[ia][ja] & B[ib][jb]);
                    }

                    System.out.println(" end ");
                }

                System.out.println(" count " + count);
                overlap = Math.max(overlap, count);
            }
            System.out.println(" First end ");
        }
        return overlap;
    }

    public static void main(String[] args) {
        int [] []A = {{1,1,0},
                {0,1,0},
                {0,1,0}};

      int [][]  B = {{0,0,0},
        {0,1,1},
        {0,0,1}};



      System.out.println(new ImageOverlap().largestOverlap(A,B));
    }
}
