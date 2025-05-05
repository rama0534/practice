package org.leetcode.Binary;

import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer to find its Reverse Bits number");
        int n = sc.nextInt();
        System.out.println("Reverse Bits number of given number is : " + reverseBits(n));
    }

    // you need treat n as an unsigned value
    private static int reverseBits(int n) {
        int reverse = 0;
        for(int i = 0; i < 32; i++){
            reverse = reverse << 1;
            // (n & 1) to get rightmost of n
            // reverse | (n & 1) to add nth rightmost bit to reverse
            reverse = reverse | (n & 1);
            n = n >> 1;
        }
        return reverse;
    }
}
