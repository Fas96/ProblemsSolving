package leetcode.Y2023.personal.bsearch;

public class Q278FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
    boolean isBadVersion(int version){
        return true;
    }
}
