package main.leetcode;

public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        if (grid.length == 0) return new Node();
        return constructTree(grid, 0, 0, grid.length, grid[0].length);
    }

    private Node constructTree(int[][] grid, int startRow, int startCol, int endRow, int endCol) {

        int length = (endCol - startCol) + (endRow - startRow);


        if (length < 0) return null;

        Node node = new Node();

        if (length == 0) {
            node.val = true;
            node.isLeaf = true;
            return node;
        }

        node.topLeft = constructTree(grid, startRow, (startRow + endRow) / 2 - 1, startCol, (startCol + endCol) / 2 - 1);
        node.bottomLeft = constructTree(grid, (startRow + endRow) / 2 + 1, startCol, endRow, (startCol + endCol) / 2 - 1);
        node.topRight = constructTree(grid, startRow, (startCol + endCol) / 2 + 1, (startRow + endRow) / 2 - 1, endCol);
        node.bottomRight = constructTree(grid, (startRow + endRow) / 2 + 1, (startCol + endCol) / 2 + 1, endRow, endCol);

        return node;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        Node root = new ConstructQuadTree().construct(grid);
        System.out.println(root);
    }
}
