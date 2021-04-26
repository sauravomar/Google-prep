package main.leetcode;

public class SmallestSubtreeWithDeepestNode {

    int maxHeight = -1;
    TreeNode result = null;

    class TreeNode {

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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;
        getDeepestNode(root, 0);
        return result;
    }


    private int getDeepestNode(TreeNode root, int height) {
        if (root == null) return height - 1;

        int left = getDeepestNode(root.left, height + 1);
        int right = getDeepestNode(root.right, height + 1);


        if (left == right && left >= maxHeight) {
            result = root;
            maxHeight = left;
        }

        return Math.max(left, right);

    }

    public static void main(String[] args) {

    }
}
