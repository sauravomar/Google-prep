package main.leetcode;

public class BalanceBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1) return false;
        if (Math.abs(right - left) > 1) return false;
        return true;

    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(right - left) > 1) return -1;
        return (Math.max(right, left) + 1);
    }

    public static void main(String[] args) {

    }
}

