package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.ListNode;
import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow.next);
        return root;
    }
    @Test
    public void test_sortedListToBST(){
        ListNode treeNode= ListNode.of(-10,-3,0,5,9);
        TreeNode convertItToAHeightBalancedBinarySearchTree= TreeNode.of(0,-3,9,-10,null,5);
        assertEquals(convertItToAHeightBalancedBinarySearchTree, sortedListToBST(treeNode));

    }

    private void printTree(TreeNode treeNode) {
        if(treeNode==null) return;
        printTree(treeNode.left);
        System.out.println(treeNode.val);
        printTree(treeNode.right);
    }
}
