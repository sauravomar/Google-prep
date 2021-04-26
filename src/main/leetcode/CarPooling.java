package main.leetcode;

import java.util.*;

public class CarPooling {

    class Trip {
        int passengers;
        int start_loc;
        int end_location;

        public Trip(int passengers, int start_loc, int end_location) {
            this.passengers = passengers;
            this.start_loc = start_loc;
            this.end_location = end_location;
        }

        public int getPassangers() {
            return passengers;
        }

        public int getStart_loc() {
            return start_loc;
        }

        public int getEnd_location() {
            return end_location;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {

        if (trips.length == 0) return true;

        List<Trip>tripList = new ArrayList<>();
        TreeMap<Integer, Integer> downPassengers = new TreeMap<>();

        for(int i=0; i<trips.length; i++){
            tripList.add(new Trip(trips[i][0],trips[i][1], trips[i][2]));
        }

        Collections.sort(tripList, (t1, t2) -> {
            if (t1.start_loc > t2.start_loc) return 1;
            else if (t1.start_loc < t2.start_loc) return -1;
            else return 0;
        });

        int currentCapacity = capacity;

        for(Trip trip: tripList){
           currentCapacity =  dropAllPassengerBefore(trip.getStart_loc(), downPassengers, currentCapacity);
           if(currentCapacity < trip.passengers) return  false;

            downPassengers.compute(trip.getEnd_location(),
                    (k, v) -> v == null ? trip.getPassangers() : v + trip.getPassangers());

            currentCapacity = currentCapacity -  trip.passengers;
        }
        return true;
    }

    private int dropAllPassengerBefore(int start_loc,
                                        TreeMap<Integer, Integer> downPassengers, int mCapacity) {
        Iterator<Map.Entry<Integer, Integer>> it = downPassengers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getKey() <= start_loc) {
                mCapacity += entry.getValue();
                it.remove();

            } else {
                break;
            }
        }

        return mCapacity;
    }

    public static void main(String[] args) {
        int trips [][] = {{2,1,5},{3,3,7}};

        System.out.println(new CarPooling().carPooling(trips, 5));
    }
}
