package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1372LongestZigZagPathInABinaryTree {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return -1;
        helper(root.right, 1, true);
        helper(root.left, 1, false);
        return max;
    }

    private  void helper(TreeNode root, int step, boolean isRight) {
        if (root == null) return;
        max = Math.max(max, step);
        if (isRight) {
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);
        } else {
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);
        }
    }

    @Test
    public void TestLongest(){
        assertEquals(3,TreeNode.of(1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1));
    }
}
