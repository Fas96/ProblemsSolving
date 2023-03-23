package leetcode.Y2023.weekly.bw100;

public class Q6325MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        long l = 0, r = ranks[0];
        r *= cars;
        r *= cars;

        long ans = 0;

        while(l<=r){
            long m = l+(r-l)/2;
            long z = 0;
            for(int i=0; i<ranks.length; i++){
                long x = m/ranks[i];
                x = (long)Math.sqrt(x);
                z +=x;
                if(z>=cars) break;
            }
            if(z>=cars){
                ans = m;
                r = m-1;
            }
            else l = m+1;
        }

        return ans;
    }
}
