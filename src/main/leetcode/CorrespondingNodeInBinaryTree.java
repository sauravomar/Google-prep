package main.leetcode;

public class CorrespondingNodeInBinaryTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == null || original == null || cloned == null) return null;

        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left == null ? right : left;
    }


}
