package main.leetcode;

public class AllBinaryStringK {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() == 0 || k == 0) return false;

        int number = (int) (Math.pow(2, k) - 1);

        boolean arr[] = new boolean[number + 1];

        int index = s.length();

        while (index - k >= 0) {
            int binaryNumber = Integer.parseInt(s.substring(index - k, index), 2);
            int val = binaryNumber & number;
            arr[val] = true;
            index--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new AllBinaryStringK().hasAllCodes("0110", 2));
    }
}
