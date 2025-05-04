package org.leetcode.arrays;

import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        System.out.println("Maximum Product Subarray: " + maxProduct(nums));
        sc.close();
    }
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int current = nums[i];

            if(current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(current * maxProd, current);
            minProd = Math.min(current * minProd, current);

            result = Math.max(maxProd, result);
        }
        return result;
    }
}
