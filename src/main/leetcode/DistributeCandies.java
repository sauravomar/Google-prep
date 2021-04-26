package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {

        if (candyType.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int candy : candyType) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }

        int maxCandy = candyType.length / 2;

        return map.size() >= maxCandy ? maxCandy : map.size();
    }
}
