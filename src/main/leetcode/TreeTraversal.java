package main.leetcode;

public class TreeTraversal {

    public void traverse(TreeNode root) {

        if (root == null) return;

        System.out.println(root.val);
        leftview(root.left);
        leafView(root);
        rightView(root.right);

        if (root.right == null) {
            System.out.println(root.left.val);
        }

    }

    public void leftview(TreeNode root) {

        if (root == null) return;

        if (root.left != null || root.right != null) {
            System.out.println(root.val);
        }

        leftview(root.left);

    }

    public void leafView(TreeNode root) {

        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.val);
        }
        leafView(root.left);
        leafView(root.right);

    }

    private void rightView(TreeNode root) {

        if (root == null) return;

        rightView(root.right);
        if (root.left != null || root.right != null) {
            System.out.println(root.val);
        }
    }

    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);

        new TreeTraversal().traverse(root);
    }
}

