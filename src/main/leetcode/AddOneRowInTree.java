package main.leetcode;

public class AddOneRowInTree {


    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;
        if(d == 1) return new TreeNode(v, root, null);
        return addRow(root, v, d, 1);
    }


    public TreeNode addRow(TreeNode root, int v, int d, int curcDep) {
        if (root == null) return root;

        if (d == curcDep) {

            TreeNode left = new TreeNode(v, root.left, null);
            TreeNode right = new TreeNode(v, null, root.right);
            root.right = right;
            root.left = left;
        } else {
            root.left = addRow(root.left, v, d, curcDep + 1);
            root.right = addRow(root.right, v, d, curcDep + 1);
        }
        return root;
    }
}
