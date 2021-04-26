package main.leetcode;

import java.util.HashMap;

public class DivisionhackerRank {

    public static String divide(int dividend, int divisor) {
        if (divisor == 0) return "";

        if (dividend % divisor == 0) return "" + (dividend / divisor);

        double result = (double) dividend / (double) divisor;
        String fractionPart = fractionToDecimal(dividend, divisor);

        fractionPart = fractionPart.replaceAll("-", "");

        if (fractionPart.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String decimal = ("" + result).split("\\.")[1];
            int index = 0;
            while (index + fractionPart.length() < decimal.length()) {
                if (!decimal.substring(index, index + fractionPart.length()).equalsIgnoreCase(fractionPart)) {
                    index++;
                } else {
                    break;
                }
            }
            return ("" + result).split("\\.")[0] + "." + decimal.substring(0, index) + "(" + fractionPart + ")";
        }

        return "" + result;
    }


    static String fractionToDecimal(int numr, int denr) {
        String res = "";

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.clear();

        int rem = numr % denr;

        while ((rem != 0) && (!mp.containsKey(rem))) {
            mp.put(rem, res.length());

            rem = rem * 10;

            int res_part = rem / denr;
            res += String.valueOf(res_part);

            rem = rem % denr;
        }

        if (rem == 0)
            return "";
        else if (mp.containsKey(rem))
            return res.substring(mp.get(rem));

        return "";
    }

    public static void main(String[] args) {
        System.out.println(divide(-1, 3));
    }

}
