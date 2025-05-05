package org.leetcode.Binary;

import java.util.Arrays;
import java.util.Scanner;

public class CountingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int n = sc.nextInt();
        System.out.println("Hamming weight from 0 to "+ n + ": " + Arrays.toString(countBits(n)));
    }
    private static int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            counts[i] = counts[i >> 1] + (i & 1);
        }
        return counts;
    }
}
