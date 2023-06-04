package leetcode.Y2023.book.educative.a3TwoPointers;

import java.util.Arrays;

public class QTripletsWithSmallerSum {
    public int searchTriplets(int[] arr, int target) {
        if(arr==null||arr.length<3) return -1;

        Arrays.sort(arr);
        int count=0;
        for (int i = 0; i < arr.length-2; i++) {
            int left=i+1,right=arr.length-1;
            while(left<right){
                int curSum=arr[i]+arr[left]+arr[right];
                if(curSum<target){
                    count+=right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
