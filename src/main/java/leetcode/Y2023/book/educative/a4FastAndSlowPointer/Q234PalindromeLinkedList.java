package leetcode.Y2023.book.educative.a4FastAndSlowPointer;

import com.github.shanepark.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q234PalindromeLinkedList {
    public boolean isPalindromeList(ListNode head) {
        List<Integer> list= new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int left=0,right=list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode p1=head,p2= reverse(slow);
        while(p1!=null&&p2!=null){
            if(p1.val!=p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;

    }

    private ListNode reverse(ListNode slow) {
        ListNode prev=null,cur=slow;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
