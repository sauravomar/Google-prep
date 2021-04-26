package main.hackerrank;

import main.graph.Graph;

import java.util.*;

public class NodeDistance {


    static final int N = 100000;
    @SuppressWarnings("unchecked")
    static Vector<Integer>[] cycles = new Vector[N];
    static int cyclenumber;

    public static List<Integer> nodeDistance(int gNodes, List<Integer> gFrom, List<Integer> gTo) {

        Integer result[] = new Integer[gNodes];
        if (gNodes == 0) return Arrays.asList(result);

        Graph graph = new Graph(gNodes);

        for (int i = 0; i < gNodes; i++) {
            graph.addEdge(gFrom.get(i) - 1, gTo.get(i) - 1);
        }


        int[] color = new int[N];
        int[] par = new int[N];
        int[] mark = new int[N];
        cyclenumber = 0;
        int edges = 13;
        dfs_cycle(graph, 1, 0, color, mark, par);

        boolean visited[] = printCycles(gNodes, edges, mark);
        List<Integer> cycleNode = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) cycleNode.add(i);
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                int distance = 0;
                for (int cycle : cycleNode) {
                    int dist = findShortestPath(graph, cycle, i);
                    if (dist < distance) distance = dist;
                }
                result[i] = distance;
            }
        }

        return Arrays.asList(result);
    }

    static void dfs_cycle(Graph graph, int u, int p, int[] color,
                          int[] mark, int[] par) {

        // already (completely) visited vertex.
        if (color[u] == 2) {
            return;
        }

        // seen vertex, but was not completely visited -> cycle detected.
        // backtrack based on parents to find the complete cycle.
        if (color[u] == 1) {

            cyclenumber++;
            int cur = p;
            mark[cur] = cyclenumber;

            // backtrack the vertex which are
            // in the current cycle thats found
            while (cur != u) {
                cur = par[cur];
                mark[cur] = cyclenumber;
            }
            return;
        }
        par[u] = p;

        // partially visited.
        color[u] = 1;

        // simple dfs on graph
        for (int v : graph.getAdj()[u]) {

            // if it has not been visited previously
            if (v == par[u]) {
                continue;
            }
            dfs_cycle(graph, v, u, color, mark, par);
        }

        // completely visited.
        color[u] = 2;
    }

    static boolean[] printCycles(int vertices, int edges, int mark[]) {


        boolean result[] = new boolean[vertices];
        for (int i = 1; i <= edges; i++) {
            if (mark[i] != 0)
                cycles[mark[i]].add(i);
        }

        // print all the vertex with same cycle
        for (int i = 1; i <= cyclenumber; i++) {
            // Print the i-th cycle
            System.out.printf("Cycle Number %d: ", i);
            for (int x : cycles[i]) {
                System.out.printf("%d ", x);
                result[x] = true;
            }
            System.out.println();
        }

        return result;
    }

    public static int findShortestPath(Graph graph, int src, int dest) {
        boolean[] visited = new boolean[2 * graph.getV()];
        int[] parent = new int[2 * graph.getV()];

        for (int i = 0; i < 2 * graph.getV(); i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {

            // Dequeue a vertex from queue and print it
            int s = queue.peek();

            if (s == dest)
                return printShortestPath(graph, parent, s, dest);
            queue.poll();

            for (int i : graph.getAdj()[s]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = s;
                }
            }
        }
        return 0;
    }

    public static int printShortestPath(Graph graph, int[] parent, int s, int d) {
        int level = 0;
        if (parent[s] == -1) {
            System.out.printf("Shortest Path between" +
                    "%d and %d is %s ", s, d, s);
            return level;
        }

        printShortestPath(graph, parent, parent[s], d);

        level++;
        if (s < graph.getV())
            System.out.printf("%d ", s);

        return level;
    }


    public static void main(String[] args) {
        int gNodes = 6;
        Integer arrFrom[] = {1, 2, 1, 3, 1, 2};
        Integer arrTo[] = {2, 3, 3, 5, 4, 6};
        System.out.println(NodeDistance.nodeDistance(gNodes, Arrays.asList(arrFrom), Arrays.asList(arrTo)));
    }
}
