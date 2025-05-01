package org.hackerrank.OneWeekPreparationKit.dayThree;

import java.util.Scanner;

/**
 * This class provides a method to determine the index of a character in a string
 * which, when removed, makes the string a palindrome.
 */
public class PalindromeIndex {

    /**
     * Determines the index of a character in the given string that can be removed
     * to make the string a palindrome. If the string is already a palindrome,
     * returns -1.
     *
     * @param s the input string to evaluate
     * @return the index of the character to remove to make the string a palindrome;
     *         -1 if no such index exists or the string is already a palindrome
     */
    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if(isPalindrome(s, left + 1, right)) {
                    return left;
                } else if (isPalindrome(s, left, right - 1)) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }
        return -1;
    }

    /**
     * Checks if the substring of a given string between the specified left and
     * right indices (inclusive) is a palindrome.
     *
     * @param s     the original string
     * @param left  the starting index of the substring
     * @param right the ending index of the substring
     * @return true if the substring is a palindrome; false otherwise
     */
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Main method to read input from the user and print the result of
     * palindromeIndex.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String s = sc.next();
        sc.close();
        System.out.println(palindromeIndex(s));
    }
}
