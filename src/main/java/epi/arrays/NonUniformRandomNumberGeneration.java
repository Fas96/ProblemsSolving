package epi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NonUniformRandomNumberGeneration {
    public int nonUniformRandomNumberGeneration(List<Integer> values,List<Double> propabilities){
        List<Double> prefixSumOfProbabilities=new ArrayList<>();
        //creating the endpoints for the intervals corresponding to the probabilities
        for (double p : propabilities) {
            prefixSumOfProbabilities.add((prefixSumOfProbabilities.isEmpty()?0:prefixSumOfProbabilities.get(prefixSumOfProbabilities.size()-1))+p);
        }
        Random r=new Random();
        //Get a rand, number in [0.0,1.0]
        double uniform01=r.nextDouble();
        //Find the index of the interval that uniform01 lies in
        int it= Collections.binarySearch(prefixSumOfProbabilities,uniform01);
        if(it<0){
           //We want the index of the first element that in the array which is greater than the key
            //When the key is not present in the array, Collections.binarySearch returns (-(insertion point) - 1) plus
            //the smallest index whose entry is greater than the key
            int intervalIdx=Math.abs(it)-1;
            return values.get(intervalIdx);
        }else{
            //We have it >= 0, i.e, uniform01 is equal to an entry in prefixSumOfProbabilities
            //Because uniform01 is a random double, the probability of it equalling an endpoint in prefixSumOfProbabilities is exceedingly low.
            //However, it is not 0, so to be robust we must consider this case.
            return values.get(it);
        }

    }
}
