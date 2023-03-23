package leetcode.Y2023.weekly.w337;

public class Q6319NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        for (int index = 0; n>0; index++,n >>= 1) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return new int[] {even, odd};
    }
}
