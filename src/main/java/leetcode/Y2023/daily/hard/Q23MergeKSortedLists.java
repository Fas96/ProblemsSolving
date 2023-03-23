package leetcode.Y2023.daily.hard;

import com.github.shanepark.leetcode.ListNode;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class Q23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode list : lists) {
            if(list!=null) pq.add(list);
        }
        ListNode tmp=new ListNode(-1);
        ListNode cur=tmp;
        while(!pq.isEmpty()){
            ListNode poll = pq.poll();
            cur.next=poll;
            cur=cur.next;
            if(poll.next!=null) pq.add(poll.next);
        }
        return tmp.next;

    }
    @Test
    public void test_mergeKLists(){
         ListNode ln1=ListNode.of(1,4,5);
         ListNode ln2=ListNode.of(1,3,4);
         ListNode ln3=ListNode.of(2,6);
         ListNode[] lists=new ListNode[]{ln1,ln2,ln3};
         assertEquals(ListNode.of(1,1,2,3,4,4,5,6), mergeKLists(lists));
    }
}
