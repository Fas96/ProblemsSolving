package leetcode.Y2023.daily.deasy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Q530MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
         List<Integer> list = new ArrayList<>();
         dfs(root, list);
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(min, list.get(i + 1) - list.get(i));
            }

         return min;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    @Test
    public void test(){
        TreeNode root= TreeNode.of(4,2,6,1,3);
        assertEquals(1,getMinimumDifference(root));
        root= TreeNode.of(1,0,48,null,null,12,49);
        assertEquals(1,getMinimumDifference(root));
        assertEquals(9,getMinimumDifference(TreeNode.of(236,104,701,null,227,null,911)));
    }
}
