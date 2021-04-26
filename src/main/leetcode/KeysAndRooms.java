package main.leetcode;

import java.util.List;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms.size() == 0) return false;

        boolean isVisited[] = new boolean[rooms.size()];

        visit(rooms, 0, isVisited);

        for (boolean hasVisited : isVisited) {
            if (!hasVisited) {
                return false;
            }
        }

        return true;
    }

    private void visit(List<List<Integer>> rooms, int roomIndex, boolean[] visited) {
        visited[roomIndex] = true;
        for (Integer keyIndex : rooms.get(roomIndex)) {
            if (!visited[keyIndex]) {
                visit(rooms, keyIndex, visited);
            }
        }
    }
}

