package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Q382LinkedListRandomNode {

    ArrayList<ListNode> listNodeArrayList;
    public Q382LinkedListRandomNode(ListNode head) {
        if (head==null)return;
        listNodeArrayList=new ArrayList<>();
        ListNode  curNode=head;
        while(curNode!=null){
            listNodeArrayList.add(curNode);
            curNode=curNode.next;
        }
    }

    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(listNodeArrayList.size());
        return listNodeArrayList.get(randomIndex).val;
    }
}
