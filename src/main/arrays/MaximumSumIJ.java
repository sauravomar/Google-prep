package main.arrays;


public class MaximumSumIJ {

    public int maxSum(int [] array){

        //store arr[i] +i
        int addArray[]  = new int[array.length];

        //store arr[ij] -j
        int subArray[]  = new int[array.length];


        for(int i=0; i< array.length; i++){
            addArray[i] = array[i] + i;
            subArray[i] = array[i] - i;
        }

        int sum = 0;

        int first = addArray[0];
        int second = addArray[0];

        int third  = subArray[0];
        int four = subArray[0];

        for(int i=0; i< array.length; i++){

            if(first > addArray[i]) first = addArray[i];
            if(second < addArray[i]) second = addArray[i];

            if(third > subArray[i]) third = subArray[i];
            if(four < subArray[i]) four = subArray[i];
        }

        return Math.abs(first-second) > Math.abs(third-four) ? Math.abs(first-second) :  Math.abs(third-four) ;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3 };

        System.out.println(new MaximumSumIJ().maxSum(array));
    }
}
