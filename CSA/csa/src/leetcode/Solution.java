package leetcode;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        int[] nums2 = new int[]{1,2,2,3};
        System.out.println(removeDuplicates(nums2));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int uniqueIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[uniqueIndex]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}