package org.leetcode.Binary;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Missing number: " + missingNumber(arr));
    }
    private static int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }
}
