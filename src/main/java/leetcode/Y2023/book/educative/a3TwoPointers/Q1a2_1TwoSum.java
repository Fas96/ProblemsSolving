package leetcode.Y2023.book.educative.a3TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1a2_1TwoSum {
    public int[] twoSumNOTSORTED(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target-num))return new int[]{map.get(target-num),i};
            map.put(num,i);
        }
        return new int[]{-1,-1};

    }
    public int[] searchSORTED(int[] arr,int targetSum){
        int left=0,right=arr.length-1;
        while(left<right){
            int curSum=arr[left]+arr[right];
            if(curSum==targetSum)return new int[]{left,right};
            if(curSum<targetSum)left++;
            else right--;
        }
        return new int[]{-1,-1};
    }

    public int[] twoSumNONSORTED(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]))return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }
}
