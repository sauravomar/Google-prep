package main.leetcode;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {

        int N = nums.length;
        int xor = 0;
        for (int i : nums)
            xor ^= i;

        for (int i = 0; i < N; i++)
            xor ^= (i + 1);

        //we cqn select any bit here, but for simplicity let's select least significant bit
        int lsb = xor & ~(xor - 1);

        int xor1 = 0;
        int xor0 = 0;

        for (int i : nums)
            if ((i & lsb) == 0)
                xor0 ^= i;
            else
                xor1 ^= i;

        for (int i = 0; i < N; i++)
            if (((i + 1) & lsb) == 0)
                xor0 ^= (i + 1);
            else
                xor1 ^= (i + 1);


        for (int i : nums) {
            if (i == xor1)
                return new int[]{xor1, xor0};
            if (i == xor0)
                return new int[]{xor0, xor1};
        }

        return null;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5};
        System.out.println(new SetMismatch().findErrorNums(arr));
    }
}
