package main.leetcode;

import main.graph.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsBipartite {

    enum Color {
        BLUE,
        RED
    }

    Map<Integer, Color> map = new HashMap<>();

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return true;

        int source = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0) {
                source = i;
                break;
            }
        }

        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                boolean result = bfs(graph, source, visited);
                if (!result) return result;
            }

        }
        return true;
    }

    public boolean bfs(int[][] graph, int src, boolean visited[]) {
        if (null == graph) return true;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        map.put(src, Color.BLUE);

        while (!queue.isEmpty()) {

            int source = queue.poll();
            Color color = map.get(source);

            for (int vertices : graph[source]) {
                if (map.containsKey(vertices) && map.get(vertices).equals(color)) {
                    return false;
                } else {
                    Color toColor = color == Color.BLUE ? Color.RED : Color.BLUE;
                    map.put(vertices, toColor);
                }
                if (!visited[vertices]) {
                    visited[vertices] = true;
                    queue.add(vertices);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int graph[][] = {{2, 4}, {2, 3, 4}, {0, 1}, {1}, {0, 1}, {7}, {9}, {5}, {}, {6}, {12, 14}, {}, {10}, {}, {10}, {19}, {18}, {}, {16}, {15}, {23}, {23}, {}, {20, 21}, {}, {}, {27}, {26}, {}, {}, {34}, {33, 34}, {}, {31}, {30, 31}, {38, 39}, {37, 38, 39}, {36}, {35, 36}, {35, 36}, {43}, {}, {}, {40}, {}, {49}, {47, 48, 49}, {46, 48, 49}, {46, 47, 49}, {45, 46, 47, 48}};

        System.out.println(new IsBipartite().isBipartite(graph));
    }
}
