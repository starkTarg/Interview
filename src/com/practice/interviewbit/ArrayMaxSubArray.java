package com.practice.interviewbit;

import java.util.Arrays;
import java.util.List;

public class ArrayMaxSubArray {

    public int maxSubArray(final List<Integer> A) {

	// if all are negative
	int maxSubArr = A.get(0);
	int tempMaxSum = 0;
	int left = 0, right = 0;
	int registeredLeft=-1, registeredRight=-1;
	int arrCounter = 0;
	for (Integer val : A) {
	    if (val < 0) {
		if (maxSubArr < val)
		    maxSubArr = val;
		arrCounter++;
		if (arrCounter == A.size()) {
		    return maxSubArr;
		}
		continue;
	    }

	}
	
	maxSubArr = A.get(0);
	tempMaxSum = 0;
	
	for (Integer val : A) {

	    tempMaxSum += val;

	    if (tempMaxSum < 0) {
		left = right + 1;
		right = left;
		tempMaxSum = 0;
		continue;

	    }

	    if (tempMaxSum >= 0) {
		right++;

	    } else {
		left = right + 1;
		right = left;
	    }
	    
	    if (maxSubArr < tempMaxSum) {
		registeredLeft = left;
		registeredRight = right-1;
		maxSubArr = tempMaxSum;
	    }

	}
	System.out.println("Left: " + registeredLeft + "Right: " + registeredRight);
	return maxSubArr;
    }

    public static void main(String[] args) {
	Integer arr[] = { -2, -1, 3,-1};
	System.out.println(new ArrayMaxSubArray().maxSubArray(Arrays.asList(arr)));
    }

}
