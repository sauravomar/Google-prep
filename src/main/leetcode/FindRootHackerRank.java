package main.leetcode;

import java.util.*;

public class FindRootHackerRank {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }
    }


    public static int findRoot(List<List<Integer>> nodes) {

        Map<Integer, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < nodes.size(); i++) {
            int val = nodes.get(i).get(0);
            nodeMap.put(val, new Node(val));
        }

        for (int i = 0; i < nodes.size(); i++) {

            Node parent = nodeMap.get(nodes.get(i).get(0));

            if (nodes.get(i).get(1) != -1) {
                Node leftChild = nodeMap.get(nodes.get(i).get(1));
                parent.left = leftChild;
            }

            if (nodes.get(i).get(2) != -1) {
                Node rightChild = nodeMap.get(nodes.get(i).get(2));
                parent.right = rightChild;
            }

            if (nodes.get(i).get(1) == -1 && nodes.get(i).get(2) == -1) nodeMap.remove(nodes.get(i).get(0));
        }


        for (int i = 0; i < nodes.size(); i++) {

            if (nodes.get(i).get(1) != -1 && nodeMap.get(nodes.get(i).get(0)).left != null) {
                if (nodeMap.containsKey((nodes.get(i).get(1)))) nodeMap.remove(nodes.get(i).get(1));
            }

            if (nodes.get(i).get(2) != -1 && nodeMap.get(nodes.get(i).get(0)).right != null) {
                if (nodeMap.containsKey((nodes.get(i).get(2)))) nodeMap.remove(nodes.get(i).get(2));
            }
        }


        if (nodeMap.size() > 1) return -1;

        for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
            if (!isCycle(entry.getValue(), nodes.size())) return -1;
            return entry.getKey();
        }
        return -1;
    }


    private static boolean isCycle(Node root, int size) {
        if (root == null) return true;
        HashSet<Integer> hashSet = new HashSet<>();
        return traverse(root, hashSet);
    }


    private static boolean traverse(Node root, HashSet<Integer> set) {
        if (root == null) return true;
        if (set.contains(root.value)) return false;
        if (root.left != null && root.value < root.left.value) return false;
        if (root.right != null && root.value > root.right.value) return false;
        set.add(root.value);
        return traverse(root.left, set) && traverse(root.right, set);

    }


    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(-1);
        list.add(-1);

        lists.add(list);

        list = new ArrayList<>();
        list.add(15);
        list.add(13);
        list.add(17);

        lists.add(list);

        list = new ArrayList<>();
        list.add(7);
        list.add(-1);
        list.add(-1);

        lists.add(list);

        list = new ArrayList<>();
        list.add(13);
        list.add(-1);
        list.add(-1);

        lists.add(list);

        list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);

        lists.add(list);

        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(-1);

        lists.add(list);

        list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(15);

        lists.add(list);


        System.out.println(FindRootHackerRank.findRoot(lists));
    }

}
