package main.leetcode;

import java.util.*;

public class EvaluateDivision {

    Map<String, HashMap<String, Double>> g = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); ++i) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double k = values[i];
            //g.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
            HashMap<String, Double> map = g.get(x);
            if (map == null) {
                g.put(x, map = new HashMap<String, Double>());
            }
            map.put(y, k);

            //g.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);
            map = g.get(y);
            if (map == null) {
                g.put(y, map = new HashMap<String, Double>());
            }
            map.put(x, 1 / k);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!g.containsKey(x) || !g.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, new HashSet<String>());
            }
        }

        return ans;
    }

    private double divide(String x, String y, Set<String> visited) {
        if (x.equals(y)) return 1.0;
        visited.add(x);
        if (!g.containsKey(x)) return -1.0;
        for (String n : g.get(x).keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = divide(n, y, visited);
            if (d > 0) return d * g.get(x).get(n);
        }
        return -1.0;
    }
}