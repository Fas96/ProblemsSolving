package leetcode.Aeasy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class Q2529MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
      return (int) Math.max(  Arrays.stream(nums).filter(neg->neg<0).count(),Arrays.stream(nums).filter(pos->pos>0).count());

    }
}
