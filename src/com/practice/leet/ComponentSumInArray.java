package com.practice.leet;
import java.util.HashMap;
import java.util.Map;

class ComponentSumInArray {
    public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            System.out.println(map.get(complement) + " " + i);
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

    public static void main(String[] args) {
	new ComponentSumInArray().twoSum(new int[] { 4,3,-2 }, 2);
    }
}