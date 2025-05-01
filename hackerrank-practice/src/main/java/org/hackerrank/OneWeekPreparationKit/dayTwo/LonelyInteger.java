package org.hackerrank.OneWeekPreparationKit.dayTwo;

import java.util.Arrays;
import java.util.List;

public class LonelyInteger {
    /**
     * This method finds the lonely integer for a given list
     *
     * @param list the list of integers to find lonely integer.
     */
    public static int lonelyInteger(List<Integer> list) {
        int result = 0;
        for (int num : list) {
            result ^= num;  // XOR cancels out duplicates
        }
        return result;
    }

    //XOR (Exclusive OR) has some important properties:
    //Bitwise OR (|): Returns 1 if at least one bit is 1, otherwise 0.
    //x ^ x = 0
    //→ A number XORed with itself is zero
    //
    //x ^ 0 = x
    //→ A number XORed with 0 is the same number
    //
    //XOR is commutative and associative
    //→ So a ^ b ^ c is the same as c ^ a ^ b

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11,2,3,4,3,2,11);
        System.out.println(lonelyInteger(list));
    }
}
