package org.leetcode.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        sc.close();
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        int product = 1;
        for(int i = 0; i < n; i++) {
            products[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i = n - 1; i >= 0; i--) {
            products[i] *= product;
            product *= nums[i];
        }
        return products;
    }
}
