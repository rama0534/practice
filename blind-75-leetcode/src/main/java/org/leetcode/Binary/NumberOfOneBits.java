package org.leetcode.Binary;

import java.util.Scanner;

public class NumberOfOneBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        int n = sc.nextInt();
        System.out.println("Hamming Weight of "+ n + " " + hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= n - 1;
            count++;
        }
        return count;
    }
}
