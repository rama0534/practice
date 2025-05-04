package org.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++)
            nums[i] = sc.nextInt();
        System.out.println(containsDuplicate(nums));
        sc.close();
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            if(set.contains(val)) return true;
            set.add(val);
        }
        return false;
    }
}
