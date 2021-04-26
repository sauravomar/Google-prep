package main.atlassian2.entity;

public class Customer {
    private int id;
    private long startTimeMills;
    private long endTimeMills;
    private int counter;


    public Customer(int id, long startTimeMills, long endTimeMills, int counter) {
        this.id = id;
        this.startTimeMills = startTimeMills;
        this.endTimeMills = endTimeMills;
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStartTimeMills() {
        return startTimeMills;
    }

    public void setStartTimeMills(long startTimeMills) {
        this.startTimeMills = startTimeMills;
    }

    public long getEndTimeMills() {
        return endTimeMills;
    }

    public void setEndTimeMills(long endTimeMills) {
        this.endTimeMills = endTimeMills;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
