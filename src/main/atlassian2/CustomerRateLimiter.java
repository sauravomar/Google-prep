package main.atlassian2;

import main.atlassian2.entity.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRateLimiter {

    Map<Integer, Integer> requestCounterMap = new HashMap<>();

    // taking values millis;
    int seconds = 10;
    int requestDefault = 5;

    Map<Integer, Customer> map = new HashMap<>();

    // considering all the customer has same defautl values of seconds and request
    public boolean rateLimit(int customerId) {

        // base case validate customer Id
        long currentTime = System.currentTimeMillis();

        synchronized (this) {

            if (map.containsKey(customerId)) {

                // within window
                if (map.get(customerId).getEndTimeMills() > currentTime && map.get(customerId).getCounter() >= 0) {
                    map.get(customerId).setCounter(map.get(customerId).getCounter() - 1);
                    return true;
                }
                //outside window
                else if (map.get(customerId).getEndTimeMills() < currentTime) {
                    map.get(customerId).setCounter(requestDefault - 1);
                    return true;
                } else {
                    return false;
                }
            } else {
                map.put(customerId, new Customer(customerId, currentTime, currentTime + seconds * 1000, requestDefault - 1));
                return true;
            }
        }
    }

//    public void setRateLimitForCustmer(int customerId, int seconds, int request) {
//
//
//    }

//

}
