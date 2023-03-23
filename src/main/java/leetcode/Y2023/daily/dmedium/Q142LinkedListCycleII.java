package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.leetcode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Q142LinkedListCycleII {
    public ListNode detectCycleASet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;

        ListNode curNode=head;
        ArrayList<ListNode> list=new ArrayList<>();

        while(curNode!=null){
            if(list.contains(curNode)){
                return curNode;
            }
            list.add(curNode);
            curNode=curNode.next;
        }
        return null;

    }

    @Test
    public void test_detectCycle(){
        ListNode node=ListNode.of(3,2,0,-4);
        int post=1;

        assertEquals(ListNode.of(1), detectCycle(node));
    }
}
