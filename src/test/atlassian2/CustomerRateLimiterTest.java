package test.atlassian2;

import main.atlassian2.CustomerRateLimiter;

public class CustomerRateLimiterTest {

    //test case


    CustomerRateLimiter rateLimiter = new CustomerRateLimiter();

    public void validRateLimiterCase() {
        rateLimiter.rateLimit(1);
    }


    public void limitReached() {
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();

        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
        new RateLimiterThread().start();
    }


    public void validUser() {

    }

    public void InValidUser() {

    }


    class RateLimiterThread extends Thread {
        @Override
        public void run() {
            boolean response = rateLimiter.rateLimit(1);
            System.out.println(response);
        }
    }

    public static void main(String[] args) {
        CustomerRateLimiterTest customerRateLimiterTest = new CustomerRateLimiterTest();
        customerRateLimiterTest.validRateLimiterCase();
        customerRateLimiterTest.limitReached();
    }

}
