package main.leetcode;

import java.util.Arrays;

public class BoatToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        if (limit == 0 || people.length == 0) return 0;
        Arrays.sort(people);

        int index = 0;
        int last = people.length - 1;

        int count = 0;

        while (index <= last) {

            if (people[last] > limit) return -1;

            int total = people[index] + people[last];

            if (total <= limit) {
                index++;
                last--;
            } else {
                last--;
            }
            count = count + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2};
        System.out.println(new BoatToSavePeople().numRescueBoats(arr, 3));
    }
}
