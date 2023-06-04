package leetcode.Y2023.book.educative.a4FastAndSlowPointer;

import com.github.shanepark.leetcode.ListNode;

public class Q876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

    }
}
