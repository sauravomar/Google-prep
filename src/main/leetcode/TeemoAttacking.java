package main.leetcode;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if(timeSeries.length == 0)return 0;
        if(timeSeries.length == 1)return duration;

        int total = 0;
        for(int i=1; i<timeSeries.length;i++)
        {
            total += Math.min(duration,timeSeries[i]-timeSeries[i-1]);
        }

        total += duration;

        return total;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
        System.out.println(new TeemoAttacking().findPoisonedDuration(arr, 5));
    }
}
