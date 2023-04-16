package atcoder;


import org.junit.Test;

import java.util.Scanner;

import static junit.framework.Assert.assertEquals;


public class QASwapOddAndEven {
    private String swapOddAndEven(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < (int) (n/2); i++) {
            char temp = chars[2*i];
            chars[2*i] = chars[2*i+1];
            chars[2*i+1] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        QASwapOddAndEven q = new QASwapOddAndEven();
        String s= new Scanner(System.in).next();

        System.out.println(q.swapOddAndEven("abcdef"));
    }

    @Test
    public void test(){
        assertEquals(new String("badcfe"),swapOddAndEven("abcdef"));
        assertEquals(new String("taocedbrgeniencrnoetts"),swapOddAndEven("atcoderbeginnercontest"));
        assertEquals(new String("aaaa"),swapOddAndEven("aaaa"));
    }


}
