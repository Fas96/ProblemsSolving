package leetcode.Y2023.weekly.bw100;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6323DistributeMoneyToMaximumChildren {
    public int distMoney(int money, int children) {
        if (money < children || children == 0) {
            return -1;
        }
        money -= children;
        int res=0;
        for(int i = 0; i < children; i++) {
            if(money - 7 >= 0) {
                money -= 7;
                res += 1;
            } else {
                if(money == 3) {
                    if(i + 1 == children) res -= 1;
                }
                money = 0;
            }
        }
        if(money>0) res -= 1;
        return Math.max(0,res);
    }

    @Test
    public void test() {
        assertEquals(1, distMoney(20, 3));
        assertEquals(2, distMoney(16, 2));
    }
}
