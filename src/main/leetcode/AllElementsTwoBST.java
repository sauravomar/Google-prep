package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer>result1= new ArrayList<>();
        inOrderTraversal(root1, result1);

        List<Integer>result2= new ArrayList<>();
        inOrderTraversal(root2, result2);

        return mergeList(result1, result2);

    }


    public void inOrderTraversal(TreeNode root, List<Integer> list){

        if(root == null) return;

        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);

    }


    public List<Integer> mergeList(List<Integer> list1, List<Integer> list2){

        List<Integer>result = new ArrayList<>();

        if(list1 == null && list2 == null) return result;

        if(list1 == null && list2 != null) return list1;

        if(list2 != null && list1 == null) return list2;


        int start1 = 0;
        int start2 = 0;

        while(start1 < list1.size() && start2 < list2.size()){

            if(list1.get(start1) > list2.get(start2)){
                result.add( list2.get(start2));
                start2++;
            }else if(list1.get(start1) == list2.get(start2)){
                result.add( list2.get(start2));
                start2++;
                result.add( list1.get(start1));
                start1++;
            }
            else{
                result.add( list1.get(start1));
                start1++;
            }
        }
        while(start1< list1.size()){
            result.add(list1.get(start1++));

        }
        while(start2< list2.size()){
            result.add(list2.get(start2++));

        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root1=new TreeNode(2);
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(4);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);


        AllElementsTwoBST obj=   new AllElementsTwoBST();

        List<Integer> result = obj.getAllElements(root1, root2);

        System.out.println(result);
    }

}
