package org.leetcode.arrays;

import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        System.out.println("Maximum sum of sub Array: "+maxSubArray(nums));
        sc.close();
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        int n = nums.length;
        for(int val : nums) {
            sum += val;
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
