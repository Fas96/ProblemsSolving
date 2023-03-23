package programmers;

public class Q다음에올숫자 {
    public int solution(int[] common) {

        boolean isArithmetic = true;
        for (int i = 1; i < common.length; i++) {
            if (common[i] - common[i - 1] != common[1] - common[0]) {
                isArithmetic = false;
                break;
            }
        }
        if(isArithmetic){
        int a = common[0];
        int d = (int) (Math.pow(2,common[1]) - Math.pow(2,common[0]));
        int n = common.length + 1;
        return a + (n - 1) * d;
        }else {
            int a = common[0];
            int r = (int) (Math.pow(2,common[1]) / Math.pow(2,common[0]));
            int n = common.length + 1;
            return a * (int) Math.pow(r, n - 1);
        }
    }
}
