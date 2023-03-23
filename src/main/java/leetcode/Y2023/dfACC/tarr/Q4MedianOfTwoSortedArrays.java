package leetcode.Y2023.dfACC.tarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Q4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list =new ArrayList<>();
        for (int n :nums1)  list.add(n);
        for (int n :nums2)  list.add(n);
        list.sort(Integer::compareTo);
        int n = list.size();
        if(n%2==0){
            return (list.get(n/2)+list.get(n/2-1))/2.0;
        }else{
            return list.get(n/2);
        }


    }
}
