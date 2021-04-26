package main.leetcode;

import java.util.*;

public class KDistanceNodes {

    List<Integer> result = new ArrayList<>();
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) return result;
        this.k = K;
        findNode(root, target);
        return result;
    }

    private int findNode(TreeNode root, TreeNode target) {

        if (root == null) return -1;

        if (root == target) {
            getNodes(root, 0);
            return 1;
        } else {

            int d1Left = findNode(root.left, target);
            int d1Right = findNode(root.right, target);

            if (d1Left != -1) {
                if (d1Left == k) result.add(root.val);
                getNodes(root.right, d1Left + 1);
                return d1Left + 1;
            } else if (d1Right != -1) {
                if (d1Right == k) result.add(root.val);
                getNodes(root.left, d1Right + 1);
                return d1Right + 1;
            } else {
                return -1;
            }
        }
    }


    private void getNodes(TreeNode root, int distance) {
        if (root == null) return;

        if (distance == k) result.add(root.val);
        else {
            getNodes(root.left, distance + 1);
            getNodes(root.right, distance + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, three, two);
        TreeNode root = new TreeNode(0, one, null);

        System.out.println(new KDistanceNodes().distanceK(root, two, 1));
    }
}
