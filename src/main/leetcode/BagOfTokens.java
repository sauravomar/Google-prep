package main.leetcode;

import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int P) {

        if(tokens.length == 0) return 0;
        Arrays.sort(tokens);

        int start = 0;
        int end  = tokens.length-1;

        int totalPoints = 0;
        int maxPoints = 0;

      while(start <= end){
            if(tokens[start] <= P){
                totalPoints ++;
                P = P - tokens[start];
                maxPoints =  Math.max(maxPoints, totalPoints);
                start++;
            }else if(totalPoints > 0){
                totalPoints--;
                P = P + tokens[end--];
            }else{
                return maxPoints;
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {

        int [] tokens  = {100,200,300,400};
        System.out.println(new BagOfTokens().bagOfTokensScore(tokens,200));
    }
}
