package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q652FindDuplicateSubtrees {


    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> ans = new LinkedList<>();
        postOrderTraversal(root, ans);
        return ans;

    }

    private String postOrderTraversal(TreeNode root, List<TreeNode> ans) {
        if(root == null) return "#";
        String subTree = postOrderTraversal(root.left, ans) + "," +  postOrderTraversal(root.right, ans) + "," + root.val;
        System.out.println(subTree);
        map.put(subTree, map.merge(subTree, 1, Integer::sum));
        if(map.get(subTree) == 2) ans.add(root);
        return subTree;
    }


    @Test
    public void test(){
        TreeNode root= com.github.shanepark.leetcode.TreeNode.of(1,2,3,4,null,2,4,null,null,4);
        List<TreeNode> ans = findDuplicateSubtrees(root);
        //[[2,4],[4]]
        List<TreeNode> expected = new LinkedList<>();
        expected.add(TreeNode.of(2,4));
        expected.add(TreeNode.of(4));
        assertEquals(ans, expected);
    }
}
