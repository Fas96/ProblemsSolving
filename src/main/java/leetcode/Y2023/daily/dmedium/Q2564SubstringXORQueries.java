package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q2564SubstringXORQueries {
    @Test
    public void test() {
        String s = "101101";
        int[][] queries = {{0, 3}, {1, 2}, {0, 0}, {0, 5}};
        substringXorQueries(s, queries);
    }
    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] answer = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int xor = start^end;
            String binary = Integer.toBinaryString(xor);
            int startIndex = s.indexOf(binary);
            int endIndex = startIndex + binary.length();
            answer[i][0] = startIndex;
            answer[i][1] = endIndex;
        }
        return answer;
    }
}
