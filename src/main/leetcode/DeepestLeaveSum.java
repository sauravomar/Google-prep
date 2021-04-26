package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeaveSum {

    int deepLeavel = 0;

    public int deepestLeavesSum(TreeNode root) {

        if (root == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        travese(root, 0, map);
        return map.get(deepLeavel);


    }

    private void travese(TreeNode root, int height, Map<Integer, Integer> map) {
        if (root == null) return;
        if (deepLeavel < height) deepLeavel = height;
        map.put(height, map.getOrDefault(height, 0) + root.val);
        travese(root.left, height + 1, map);
        travese(root.right, height + 1, map);
    }
}
