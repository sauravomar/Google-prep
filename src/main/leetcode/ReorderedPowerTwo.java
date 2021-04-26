package main.leetcode;

import java.util.HashSet;

public class ReorderedPowerTwo {

    public boolean reorderedPowerOf2(int N) {

        if (N == 1 || N == 0) return false;

        String result = (N + "").chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        HashSet<Integer> set = generateIntegers(N);

        if (set.contains(Integer.parseInt(result))) return true;
        return false;

    }


    private HashSet<Integer> generateIntegers(int N) {

        HashSet<Integer> set = new HashSet<>();

        int number = 1;
        String str = "" + N;
        int power = (int) Math.pow(2, number);


        while (("" + power).length() < str.length()) {
            number++;
            power = (int) Math.pow(2, number);
        }

        while ((("" + power).length() == str.length())) {
            power = (int) Math.pow(2, number);
            number++;

            if (("" + power).length() != str.length()) break;

            String result = (power + "").chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            set.add(Integer.parseInt(result));
        }

        return set;

    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerTwo().reorderedPowerOf2(124));
    }
}
