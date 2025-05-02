package org.hackerrank.OneWeekPreparationKit.dayFive;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine(); // {[()]}   {[(])}
        System.out.println(isBalanced(brackets));
        sc.close();
    }
    public static String isBalanced(String s) {
        Stack<Character> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                bracket.push(c);
            } else {
                if(bracket.isEmpty()) return "NO";
                char lastChar = bracket.pop();
                if( (c == ')' &&  lastChar != '(') ||
                        (c == '}' &&  lastChar != '{') ||
                        (c == ']' &&  lastChar != '[')) {
                    return "NO";
                }
            }
        }
        return bracket.isEmpty() ? "YES" : "NO";
    }
}
