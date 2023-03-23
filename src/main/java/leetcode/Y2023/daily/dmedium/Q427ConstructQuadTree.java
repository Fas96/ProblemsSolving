package leetcode.Y2023.daily.dmedium;

import baeldung.ReversingLinkedList.ListNode;
import com.github.shanepark.Ps;
import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

public class Q427ConstructQuadTree {
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

    ;

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int gridX, int gridY, int length) {
        if (length == 1) return new Node(grid[gridX][gridY] == 1, true);
        int half = length / 2;
        Node topLeft = construct(grid, gridX, gridY, half);
        Node topRight = construct(grid, gridX, gridY + half, half);
        Node bottomLeft = construct(grid, gridX + half, gridY, half);
        Node bottomRight = construct(grid, gridX + half, gridY + half, half);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    };
}

