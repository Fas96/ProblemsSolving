package leetcode.Y2023.book.educative.a4FastAndSlowPointer;

public class Q457CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(isCycle(nums,i)){
                return true;
            }
        }
        return false;

    }

    private boolean isCycle(int[] nums, int i) {
        boolean isForward=nums[i]>=0;
        int slow=i,fast=i;
        do{
            slow=getNextIndex(nums,isForward,slow);
            fast=getNextIndex(nums,isForward,fast);
            if(fast!=-1){
                fast=getNextIndex(nums,isForward,fast);
            }
        }while(slow!=-1&&fast!=-1&&slow!=fast);
        return slow!=-1&&slow==fast;
    }

    private int getNextIndex(int[] nums, boolean isForward, int slow) {
        boolean direction=nums[slow]>=0;

        if(isForward!=direction)return -1;

        int nextIndex=(slow+nums[slow])%nums.length;

        if(nextIndex<0)nextIndex+=nums.length;
        if(nextIndex==slow)return -1;

        return nextIndex;
    }
}
