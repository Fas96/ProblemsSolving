package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd||postStart>postEnd) return null;
        int rootVal=postorder[postEnd];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                rootIndex=i;
                break;
            }
        }
        int leftSize=rootIndex-inStart;
        root.left=buildTree(inorder,inStart,rootIndex-1,postorder,postStart,postStart+leftSize-1);
        root.right=buildTree(inorder,rootIndex+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
    //simple solution
    public TreeNode buildTreeAA(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0) return null;
        if (length == 1) return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[length - 1]);
        int index = 0;
        while (inorder[index] != root.val) index++;

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, length), Arrays.copyOfRange(postorder, index, length - 1));
        return root;
    }

    @Test
    public void test(){
        TreeNode inOrder= TreeNode.of(9,3,15,20,7);
        TreeNode postOrder= TreeNode.of(9,15,7,20,3);
        TreeNode normalTree= TreeNode.of(3,9,20,null,null,15,7);
        TreeNode root=buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});

        assertEquals(normalTree,root);
    }
    private void printTreeInOrder(TreeNode root){
        if(root==null) return;
        printTreeInOrder(root.left);
        System.out.println(root.val);
        printTreeInOrder(root.right);
    }
}
