package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q129SumRootToLeafNumbers {
    List<List<Integer>> pathValues = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> path = new ArrayList<>();
        dfs(root, path);

        int sum = 0;
        for (List<Integer> pathValue : pathValues) {
            int pathSum = 0;
            for (int i = 0; i < pathValue.size(); i++) {
                pathSum += pathValue.get(i) * Math.pow(10, pathValue.size() - i - 1);
            }
            sum += pathSum;
        }
        return sum;

    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            pathValues.add(new ArrayList<>(path));
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }


    @Test
    public void sumNumbersTest(){
        TreeNode root=TreeNode.of(1,2,3);
//        assertEquals(25,sumNumbers(root));
        root=TreeNode.of(4,9,0,5,1);
        assertEquals(1026,sumNumbers(root));
    }
}
