package leetcode.Bmedium.a1457PseudoPalindromicPathsinaBinaryTree;

import lombok.val;

import javax.swing.tree.TreeNode;
import java.util.*;

public class a1457PseudoPalindromicPathsinaBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    List<List<Integer>> twodArra= new ArrayList<>();
    public int pseudoPalindromicPathsTLE (TreeNode root) {

        int path[] = new int[1000];
        dfs(root, path, 0);

        int ttAn=  getPseudoPalindromeCount();
        return ttAn;
    }

    private int getPseudoPalindromeCount() {
        int ttAn =0;
        for (List<Integer> ls : twodArra) {
            Map<Integer,Integer> mp = new HashMap<>();
            for (Integer num : ls) {
                mp.merge(num,1,Integer::sum);
            }
            int count=0;
            for (Map.Entry kev:mp.entrySet()) {
                count+= ((int)kev.getValue()%2);
            }
            if(count<=1) ttAn++;

        }
        return ttAn;
    }


    void dfs(TreeNode node, int path[], int pathLen){
        if (node == null)
            return;
        path[pathLen] = node.val;
        pathLen++;
        if (node.left == null && node.right == null){
            makeList(path, pathLen);}
        else {

            dfs(node.left, path, pathLen);
            dfs(node.right, path, pathLen);
        }
    }


    private void makeList(int ints[], int len){
        List<Integer> stack = new ArrayList<>();
        int i;
        for (i = 0; i < len; i++)
            stack.add(ints[i]);

        twodArra.add(stack);

    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root,new HashSet());
    }

    private int dfs(TreeNode node,Set<Integer> numbers){
        if(node==null) return 0;
        if(numbers.contains(node.val)){
            numbers.remove(node.val);
        }else{
            numbers.add(node.val);
        }
        if(node.left==null&& node.right==null){
            return numbers.size()<=1?1:0;
        }
        int left=dfs(node.left,new HashSet(numbers));
        int right=dfs(node.right,new HashSet(numbers));
        return left+right;
    }
}
