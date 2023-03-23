package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.TreeSet;

public class Q264UglyNumberII {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long poll = set.pollFirst();
            set.add(poll * 2);
            set.add(poll * 3);
            set.add(poll * 5);
        }
        return set.first().intValue();

    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        TreeSet<Long> set = new TreeSet<>();
       //An ugly number is a positive integer that is divisible by a, b, or c.
        //
        //Given four integers n, a, b, and c, return the nth ugly number.
        set.add(1L);

        for (int i = 0; i < n; i++) {
            long poll = set.pollFirst();
            set.add(poll * a);
            set.add(poll * b);
            set.add(poll * c);
        }
        System.out.println(set);
        return set.first().intValue();
    }

    @Test
    public void test_nthUglyNumber(){
        System.out.println(nthUglyNumber(3,2,3,5));
    }
}
