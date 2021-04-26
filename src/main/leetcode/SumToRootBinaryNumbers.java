package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumToRootBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        if(root  == null) return 0;
        return getSum(root,"",new ArrayList<>()).stream()
                .mapToInt(i -> i).sum();
    }


    public List<Integer>getSum(TreeNode root, String str, List<Integer>list){
        if(root == null) return  list;

        if(root.left == null && root.right == null){
            int val = Integer.parseInt(str+root.val, 2);
            list.add(val);
        }else{
            getSum(root.left, str + root.val,list);
            getSum(root.right, str+ root.val,list);
        }
        return list;
    }

    public static void main(String[] args) {

        SumToRootBinaryNumbers tree = new SumToRootBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left =  new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        System.out.println(new SumToRootBinaryNumbers().sumRootToLeaf(root));
    }
}
