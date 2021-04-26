package main.leetcode;


//A kindergarten teacher wants to give some candies to the children in her class.  All the children  sit in a line and each of them has a rating score according to his or her performance in the class.
//
//        Alice wants to give at least 1 candy to each child.
//
//        If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.
//        two children have equal ratings, they are allowed to have different numbers of candies
//
//        For example, assume her students' ratings are [4, 6, 4, ,5, 6, 2, 1]. She gives the students candy in the following minimal amounts: [1, 2 1, 2, 3, 1]. She must buy a minimum of 10 candies.
//        [1,2,2] = 4 (Here 1, 2, 2 is the rating.
//
//        Note that when two children have equal ratings, they are allowed to have different numbers of candies. Hence optimal distribution will be 1, 2, 1.)


// [1, 2 1, 2, 3, 1]

import java.util.Arrays;

// Assumption rank should not be 0;
public class CandiesDistribution {

    public int[] getMinimumCandies(int ranks[]) {

        //base case
        if (ranks.length == 0) return new int[0];

        int candies[] = new int[ranks.length];

        if (ranks[0] >= ranks[1]) candies[0] = 2;
        else candies[0] = 1;

        for (int i = 1; i < ranks.length; i++) {

            if (ranks[i] >= ranks[i - 1]) {
                if (ranks[i] == ranks[i - 1] && (candies[i - 1] > 1)) {
                    candies[i] = 1;
                } else {
                    candies[i] = candies[i - 1] + 1;
                }
            } else {
                if (candies[i - 1] == 1) {
                    int index = i - 1;
                    while (index > 0 && ranks[index] >= ranks[index + 1]) {
                        candies[index] = candies[index] + 1;
                        index--;
                    }
                }
                candies[i] = 1;
            }
        }
        System.out.println(Arrays.stream(candies).sum());
        return candies;
    }

    public static void main(String[] args) {

        int ranks[] = {10, 20, 30, 20, 10, 5};
        new CandiesDistribution().getMinimumCandies(ranks);
    }
}
