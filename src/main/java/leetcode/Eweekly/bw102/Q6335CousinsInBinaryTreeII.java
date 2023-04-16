package leetcode.Eweekly.bw102;

import com.github.shanepark.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q6335CousinsInBinaryTreeII {


    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        replaceValueInTree(root, null, 0, map, map2);
        replaceValueInTree(root, 0, null, map, map2);
        return root;
    }

    private void replaceValueInTree(TreeNode root, TreeNode parent, int depth, HashMap<TreeNode, Integer> map,
                                    HashMap<Integer, Integer> map2) {
        if (root != null) {
            if (parent != null) {
                map.put(parent, map.getOrDefault(parent, 0) + root.val);
            }
            map2.put(depth, map2.getOrDefault(depth, 0) + root.val);
            replaceValueInTree(root.left, root, depth + 1, map, map2);
            replaceValueInTree(root.right, root, depth + 1, map, map2);
        }
    }

    private void replaceValueInTree(TreeNode root, int depth, TreeNode parent, HashMap<TreeNode, Integer> map,
                                    HashMap<Integer, Integer> map2) {
        if (root != null) {
            root.val = parent == null ? 0 : map2.get(depth) - map.get(parent);
            replaceValueInTree(root.left, depth + 1, root, map, map2);
            replaceValueInTree(root.right, depth + 1, root, map, map2);
        }
    }
}
