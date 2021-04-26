package main.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {


    public List<Double> averageOfLevels(TreeNode root) {

        TreeNode tempNode = new TreeNode(Integer.MAX_VALUE);

        List<Double> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(tempNode);

        long sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {

            TreeNode top = queue.remove();

            if (top == tempNode) {
                list.add(Double.valueOf((double) sum / count));
                sum = 0;
                count = 0;
                if(!queue.isEmpty()) queue.add(tempNode);
                continue;
            }
            sum = sum + top.val;
            count++;
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(2147483647);
        TreeNode twnry = new TreeNode(2147483647);
        TreeNode root = new TreeNode(2147483647, nine, twnry);

        System.out.println(new AverageLevelsBinaryTree().averageOfLevels(root));
    }
}
