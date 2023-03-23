package leetcode.Y2023.weekly.w335;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class Q6309SplitTheArrayToMakeCoprimeProducts {
    public int findValidSplit(int[] nums) {
        int possible =0;
        int n = nums.length;
        for(int i=0;i<=possible;i++){
            int ele = nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]%ele==0) possible = Math.max(possible,j);
                if(ele%nums[j]==0) possible = Math.max(possible,j);
            }
        }
        return possible<=(n-2)?possible:-1;
    }


    @Test
    public void testFindValidSplit(){
        assertEquals(2, findValidSplit(new int[]{4,7,8,15,3,5}));
        assertEquals(-1, findValidSplit(new int[]{4,7,15,8,3,5}));
        assertEquals(0, findValidSplit(new int[]{2,3,3}));
        assertEquals(18, findValidSplit(new int[]{557663,280817,472963,156253,273349,884803,756869,763183,557663,964357,821411,887849,891133,453379,464279,574373,852749,15031,156253,360169,526159,410203,6101,954851,860599,802573,971693,279173,134243,187367,896953,665011,277747,439441,225683,555143,496303,290317,652033,713311,230107,770047,308323,319607,772907,627217,119311,922463,119311,641131,922463,404773,728417,948281,612373,857707,990589,12739,9127,857963,53113,956003,363397,768613,47981,466027,981569,41597,87149,55021,600883,111953,119083,471871,125641,922463,562577,269069,806999,981073,857707,831587,149351,996461,432457,10903,921091,119083,72671,843289,567323,317003,802129,612373}));
    }
}
