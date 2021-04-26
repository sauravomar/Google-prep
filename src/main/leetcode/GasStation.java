package main.leetcode;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {


        int total = 0;
        int sumRemain = 0;
        int start =0;


        for(int i=0; i<gas.length; i++){

            int remain = gas[i] - cost[i];

            if(sumRemain > 0){
                sumRemain = sumRemain+remain;
            }else{
                sumRemain = remain;
                start = i;
            }
            total = total + remain;
        }

        if(total >=0) return start;
        else return -1;
    }

    public static void main(String[] args) {
        int []  gas  = {4,5,2,6,5,3};
        int [] cost = {3,2,7,3,2,9};

        System.out.println(new GasStation().canCompleteCircuit(gas,cost));

    }
}
