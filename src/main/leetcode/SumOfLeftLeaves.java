package main.leetcode;

import main.tree.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {

        TreeNode node_15 = new TreeNode(15, null, null);
        TreeNode node_7 = new TreeNode(7, null, null);
        TreeNode node_20 = new TreeNode(20, node_15, node_7);

        TreeNode node_9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, node_9, node_20);

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));

    }
}
