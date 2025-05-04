package org.leetcode.arrays;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        System.out.println("Minimum in Rotated Sorted Array: " + findMin(nums));
        sc.close();
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
