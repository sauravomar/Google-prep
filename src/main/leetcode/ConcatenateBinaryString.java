package main.leetcode;

import java.math.BigInteger;

public class ConcatenateBinaryString {

    public int concatenatedBinary(int n) {
        if (n == 0) return 0;

        int mod = (int) (Math.pow(10, 9) + 7);
        long val = 1;

        for (int i = 2; i <= n; i++) {
            val = (val << (Integer.toBinaryString(i).length())) % mod;
            System.out.println(val);
            val = (val % mod + i % mod) % mod;
            System.out.println(val);
        }

        return (int) val % mod;

    }

    public static void main(String[] args) {
        System.out.println(new ConcatenateBinaryString().concatenatedBinary(4));
    }
}
