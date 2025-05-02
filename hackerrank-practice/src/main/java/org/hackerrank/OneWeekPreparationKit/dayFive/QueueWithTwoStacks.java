package org.hackerrank.OneWeekPreparationKit.dayFive;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        MyQueue queue = new MyQueue();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if(type == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else if( type == 2) {
                System.out.println(queue.dequeue());
            } else if(type == 3) {
                System.out.println(queue.peak());
            }
        }
        sc.close();

    }
    static class MyQueue {
        Stack<Integer> stackNewestOnTop = new Stack<>();
        Stack<Integer> stackOldestOnTop = new Stack<>();
        public void enqueue(int x) {
            stackNewestOnTop.push(x);
        }
        public void shiftStacks() {
            if(stackOldestOnTop.isEmpty()) {
                while(!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
        public int dequeue() {
            shiftStacks();
            return stackOldestOnTop.pop();
        }
        public int peak() {
            shiftStacks();
            return stackOldestOnTop.peek();
        }
    }
}
