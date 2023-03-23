package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q2348NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarrayTP(int[] nums) {
        int N=nums.length;
        long zeros=0;
        for (int i = 0,j=0; i < N; i++) {
            if(nums[i]!=0) j=i+1;
            zeros+=(i-j+1);
        }
        return zeros;
    }
    public long zeroFilledSubarray(int[] nums) {
        int N=nums.length;
        long subZerosCount=0;

        int L=-1;
        for (int i = 0; i < N; i++) {
            if(nums[i]!=0) L=i;
            else subZerosCount+=(i-L);
        }
        return subZerosCount;
//        int N=nums.length;
//        int subZerosCount=0;
//
//        for (int i = 0; i < N; i++) {
//            if(nums[i]!=0) continue;
//            int L=i;
//            while (L<N && nums[L]==0){
//                L++;
//                subZerosCount++;
//            }
//        }
//
//        return subZerosCount;

    }
    @Test
    public void  testZeroFilledSubarray(){
        assertEquals(6,zeroFilledSubarrayTP(new int[]{1,3,0,0,2,0,0,4}));
        assertEquals(9,zeroFilledSubarrayTP(new int[]{0,0,0,2,0,0}));
        assertEquals(0,zeroFilledSubarrayTP(new int[]{2,10,2019}));
    }
}
