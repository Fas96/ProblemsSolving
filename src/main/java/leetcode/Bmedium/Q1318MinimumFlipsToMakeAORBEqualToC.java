package leetcode.Bmedium;

public class Q1318MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int totalFlips=0;

        while (a>0 || b>0 || c>0){
            int Abit=1&a;
            int Bbit=1&b;
            int Cbit=1&c;

            if((Abit | Bbit) !=Cbit){
                if(Cbit==1){
                    totalFlips++;
                }else{
                    if(Abit==1 && Bbit==1)totalFlips+=2;
                    else if (Abit==1 || Bbit==1) totalFlips++;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return totalFlips;

    }

    public int minFlipsB(int a, int b, int c) {
        boolean[] A = getBits(a);
        boolean[] B = getBits(b);
        boolean[] C = getBits(c);
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((A[i] | B[i]) != C[i]) counter++;
            if ((A[i] & B[i]) && C[i] == false) counter++;
        }
        return counter;
    }


    //Returns the bits array of x
    private boolean[] getBits(int x) {
        boolean[] bits = new boolean[32];
        for (int i = 0; x != 0 && i < 32; i++) {
            bits[31 - i] = x % 2 == 1 ? true : false;
            x /= 2;
        }
        return bits;
    }
}
