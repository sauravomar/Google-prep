package main.tree;

public class MirrorTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return root;

        TreeNode tempNode  =  root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root ;

    }

    public static void main(String[] args) {

    }
}
