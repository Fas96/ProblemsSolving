package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q2568MinimumImpossibleOR {
    public int minImpossibleOR(int[] nums) {
//        int y=0;
//        for (int nb :nums){
//            if((nb && (nb-1))){y|=nb;}
//        }
//        for(int i=0;i<30;i++){
//            if(y>>i && 1)return 1<<i;
//        }
//
//        return 1<<30;
        int y=0;
        for (int nb :nums){
            if((nb & (nb-1))!=0){y|=nb;}
        }
        for(int i=0;i<30;i++){
            if((y>>i & 1)==1)return 1<<i;
        }

        return 1<<30;

    }

    @Test
    public void test(){
        assertEquals(1,Math.pow(2,29));
    }
}
