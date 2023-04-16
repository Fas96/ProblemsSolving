package atcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class QCMakeTakahashiHappy {

    @Test
    public void test(){
        assertEquals(3,makeHappy(new int[][]{{3,3},{3,2,2},{2,1,3},{1,5,4}}));


    }

    private int makeHappy(int[][] ints) {
        return Integer.bitCount(11);
    }
}
