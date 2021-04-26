package main.tree;

import java.util.*;

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>>list =  new ArrayList<>();

        if(root == null) return list;

        TreeNode temp  = new TreeNode(Integer.MAX_VALUE);

        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        List<Integer>levelList = new ArrayList<>();

        queue.add(root);
        queue.add(temp);

        while(!queue.isEmpty()){
            TreeNode top = queue.remove();

            if(temp == top){
                list.add(levelList);
                levelList = new ArrayList<>();
                queue.add(temp);
                continue;

            }else{
                levelList.add(top.val);

            }

            if(top.left != null) queue.add(top.left);
            if(top.right != null)queue.add(top.right);

            if(queue.size() == 1 && temp == queue.peek()){
                list.add(levelList);
                break;
            }

        }


        Collections.reverse(list);
        return list;

    }

    public static void main(String[] args) {
        TreeNode child1 = new TreeNode(15);
        TreeNode child2 = new TreeNode(17);
        TreeNode child3= new TreeNode(9);
        TreeNode child4= new TreeNode(20, child1, child2) ;
        TreeNode root = new TreeNode(3, child3, child4) ;

       System.out.println(new LevelOrderTraversal().levelOrderBottom(root));
    }
}
