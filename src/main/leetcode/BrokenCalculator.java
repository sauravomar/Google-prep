package main.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        int operation = 0;

        int currentNumber = Y;


        while (currentNumber != X) {
            if (currentNumber > X && currentNumber % 2 == 0) {
                currentNumber = currentNumber / 2;
            } else {
                currentNumber = currentNumber + 1;
            }
            operation++;
        }
        return operation;
    }

    public static void main(String[] args) {
        System.out.println(new BrokenCalculator().brokenCalc(1024, 1));
    }


}

class UserStats {
    Optional<Long> visitCount;
}

class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {

        Map<Long, Long> userVisitCount = new HashMap<>();

        for (Map<String, UserStats> map : visits) {
            for (Map.Entry<String, UserStats> entry : map.entrySet()) {
                try {

                    if (entry.getValue().visitCount.isPresent()) {

                        Long userId = Long.parseLong(entry.getKey());
                        Long count = entry.getValue().visitCount.get();

                        if (userVisitCount.containsKey(userId)) {
                            count = count + userVisitCount.get(userId);
                        }
                        userVisitCount.put(userId, count);
                    }
                } catch (Exception ex) {
                    // skip or abosrb exception for now.
                }
            }
        }

        return userVisitCount;
    }
}

