package leetcode.Y2023.book.educative.a4FastAndSlowPointer;

import com.github.shanepark.leetcode.ListNode;

public class Q142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        int cyceLength=0;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) {
                cyceLength=calculateCycleLength(slow);
            }
        }
        return findStart(head,cyceLength);
    }

    private ListNode findStart(ListNode head, int cyceLength) {
        ListNode p1=head,p2=head;
        while(cyceLength>0){
            p2=p2.next;
            cyceLength--;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    private int calculateCycleLength(ListNode slow) {
        ListNode cur=slow;
        int length=0;
        do{
            cur=cur.next;
            length++;
        }while(cur!=slow);
        return length;
    }
}
