package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Q526BeautifulArrangement {

    public int countArrangementBitMask(int n) {
        int[][] dp = new int[n+1][1<<n];
        return bitMask(n, 1, 0, dp);
    }
    public int bitMask(int n, int i, int mask, int[][] dp){
        if(i>n) return 1;
        if(dp[i][mask] != 0) return dp[i][mask];
        int ans = 0;
        System.out.println(Arrays.deepToString(dp));
        for(int j=1;j<=n;j++){
            if((mask&(1<<(j-1))) > 0) continue;
            if(j%i == 0 || i%j == 0)
                ans += bitMask(n, i+1, mask|(1<<(j-1)), dp);
        }
        return dp[i][mask] = ans;
    }

    int isBeautiful= 0;
    public int countArrangement(int n) {
        boolean []visited= new boolean[n+1];
        bfs(n, visited, 1);
        return isBeautiful;
    }
    public void bfs(int n, boolean []visited, int c){

        if( c > n){ isBeautiful+= 1;return;}

        for ( int i= 1; i <= n; i++){
            if ( !visited[i] && ( i % c == 0 || c % i == 0 )){
                visited[i]= true;
                bfs( n, visited, c+1);
                visited[i]= false;
            }
        }
    }

    @Test
    public void test(){
//        assertEquals(2,countArrangement(2));
//        assertEquals(1,countArrangement(1));
        assertEquals(3,countArrangement(3));
    }
}
