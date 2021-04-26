package main.leetcode;

public class PowerOfFour {


    public boolean isPowerOfFour(int num) {

        if( num == 0)
            return false;

        if((num & (num-1)) == 0){

            int count = 0;

            while(num > 1)
            {
                num >>= 1;
                count += 1;
            }
            return (count%2 == 0)? true :false;
        }

        return false;
    }
}
