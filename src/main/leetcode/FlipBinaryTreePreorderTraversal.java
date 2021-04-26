package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreePreorderTraversal {

    boolean isNotPossible = false;
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        if (root == null || voyage.length == 0) return result;
        preorderTraversal(root, voyage, result);

        if (isNotPossible) {
            result = new ArrayList<>();
            result.add(-1);
        }
        return result;
    }

    private void preorderTraversal(TreeNode root, int voyage[], List<Integer> result) {
        if (root == null || isNotPossible) return;

        if (root.val == voyage[index]) {
            index = index + 1;
            if (root.left != null && root.left.val != voyage[index]) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                result.add(root.val);
            }
            preorderTraversal(root.left, voyage, result);
            preorderTraversal(root.right, voyage, result);
        } else {
            result.add(-1);
            isNotPossible = true;
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        int[] voyage = {1, 2};
        System.out.println(new FlipBinaryTreePreorderTraversal().flipMatchVoyage(root, voyage));
    }
}
