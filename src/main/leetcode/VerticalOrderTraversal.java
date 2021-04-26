package main.leetcode;

import java.util.*;

public class VerticalOrderTraversal {

    Map<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void traverse(TreeNode root, int index) {

        if (root == null) return;
        List<Integer> list = map.getOrDefault(index, new ArrayList<>());
        list.add(root.val);
        map.put(index, list);
        traverse(root.left, index - 1);
        traverse(root.left, index + 1);
    }
}

