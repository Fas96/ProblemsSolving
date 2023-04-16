package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q2300SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);

        for(int i=0; i<n; i++){
            int L = 0;
            int R = m - 1;
            while (L <= R) {
                int mid = L + (R - L) / 2;
                long product = (long) spells[i] * potions[mid];
                if (product >= success) R = mid - 1;
                else L = mid + 1;
            }
            ans[i] = m - L;
        }

        return ans;

    }
    @Test
    public void test() {
//        assertEquals(new int[]{4,0,3}, successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7));
        assertEquals(new int[]{2,0,2}, successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16));
    }
}
