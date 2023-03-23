package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertEquals;

public class Q958CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaf) return false;
                queue.add(node.left);
            } else {
                isLeaf = true;
            }
            if (node.right != null) {
                if (isLeaf) return false;
                queue.add(node.right);
            } else {
                isLeaf = true;
            }
        }
        return true;

    }



    @Test
    public void test(){
        TreeNode root= TreeNode.of(1,2,3,4,5,6);
        assertEquals(true,isCompleteTree(root));
        root= TreeNode.of(1,2,3,4,5,null,7);
        assertEquals(false,isCompleteTree(root));
    }
}
