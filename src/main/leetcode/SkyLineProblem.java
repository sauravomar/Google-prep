package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkyLineProblem {


    static class BuildingPoint implements Comparable<BuildingPoint> {

        int x;
        boolean isStart;
        int height;

        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> result = new ArrayList<>();

        if (buildings.length == 0) return result;


        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);


        TreeMap<Integer, Integer> queue = new TreeMap<>();

        queue.put(0, 1);
        int prevMaxHeight = 0;

        for (BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else { //if it is end of building then decrement or remove the height from map.
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();

            if (prevMaxHeight != currentMaxHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(currentMaxHeight);
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;

    }
}
