
package org.hackerrank.OneWeekPreparationKit.dayFive;

import java.util.Scanner;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeSortedLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode headA = null;
        SinglyLinkedListNode  headB = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in first list");
        int n = sc.nextInt(); // n = First List size; // 3
        for (int i = 0; i < n; i++) { // 1 -> 3 -> 7
            int data = sc.nextInt();
            headA = insertNode(headA, data);

        }
        System.out.println("Enter number of elements in second list");
        int m = sc.nextInt(); // m = 2
        for (int i = 0; i < m; i++) { // 1 -> 2
            int data = sc.nextInt();
            headB = insertNode(headB, data);
        }
        sc.close();
        SinglyLinkedListNode mergedHead = mergeLists(headA, headB);
        printList(mergedHead);
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        SinglyLinkedListNode mergedHead = null;
        SinglyLinkedListNode mergedTail = null;

        if (head1.data <= head2.data) {
            mergedHead = mergedTail = head1;
            head1 = head1.next;
        } else {
            mergedHead = mergedTail = head2;
            head2 = head2.next;
        }

        while(head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                mergedTail.next = head1;
                mergedTail = head1;
                head1 = head1.next;
            } else {
                mergedTail.next = head2;
                mergedTail = head2;
                head2 = head2.next;
            }
        }

        if(head1 != null) {
            mergedTail.next = head1;
        } else {
            mergedTail.next = head2;
        }

        return mergedHead;
    }

    private static SinglyLinkedListNode insertNode(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null) return newNode;
        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.println(head.data + "");
            head = head.next;
        }
    }
}
