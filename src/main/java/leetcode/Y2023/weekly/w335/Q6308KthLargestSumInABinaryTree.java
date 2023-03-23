package leetcode.Y2023.weekly.w335;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q6308KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        long[] sums = new long[1000000];
        int maxLevel = 0;
        dfs(root, sums, 0);
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] != 0) {
                maxLevel = i;
            }
        }
        if (k > maxLevel + 1) {
            return -1;
        }
        Arrays.sort(sums);
        return sums[sums.length - k];

    }

    private void dfs(TreeNode root, long[] sums, int i) {
        if (root == null) {
            return;
        }
        sums[i] += root.val;
        dfs(root.left, sums, i + 1);
        dfs(root.right, sums, i + 1);
    }


    @Test
    public void testKthLargestLevelSum() {
         TreeNode root= TreeNode.of(5,8,9,2,1,3,7,4,6);
         assertEquals(13, kthLargestLevelSum(root, 2));

         root=TreeNode.of(1,2,null,3);
        assertEquals(3, kthLargestLevelSum(root, 1));
        root=TreeNode.of(605481,null,87336,null,226750);
        assertEquals(605481, kthLargestLevelSum(root, 1));

        root=TreeNode.of(5,8,9,2,1,3,7);
        assertEquals(-1, kthLargestLevelSum(root, 4));
    }
}
