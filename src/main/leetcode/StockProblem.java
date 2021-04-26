package main.leetcode;

public class StockProblem {

    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        int maxProfit = 0;

        int localMin = Integer.MAX_VALUE;
        int localMax = Integer.MIN_VALUE;

        int localMinIndex = -1;
        int localMaxIndex = -1;

        int start =0;

        boolean isInc = false;

        while (start < prices.length){

            isInc = false;

            while ((start <= prices.length - 1) && (prices[start] <= localMin)){
                localMin =  prices[start];
                localMinIndex=start;
                start++;
                isInc= true;
            }

            while ((start <= prices.length - 1) && (prices[start] >= prices[start-1])){
                localMax=  prices[start];
                localMaxIndex=start;
                start++;
                isInc=true;
            }

            int  profit = localMax - localMin;

           if( localMaxIndex >localMinIndex && localMax !=Integer.MIN_VALUE && localMin != Integer.MIN_VALUE && maxProfit < profit) maxProfit = profit;

            if (start >= prices.length-1)
                break;
             if(!isInc)start++;
        }
        return  maxProfit;
    }

    public static void main(String[] args) {
        int arr [] =  {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(new StockProblem().maxProfit(arr));
    }
}
