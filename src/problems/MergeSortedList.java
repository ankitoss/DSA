package problems;

import pojo.SinglyLinkedListNode;

public class MergeSortedList {

    public SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode A, SinglyLinkedListNode B) {
        if (A == null) return B;
        if (B == null) return A;
        SinglyLinkedListNode head, nextA, nextB, current;
        if (A.val < B.val) {
            head = A;
            nextA = head.next;
            nextB = B;
        } else {
            head = B;
            nextA = A;
            nextB = head.next;
        }
        current = head;

        while (nextA != null && nextB != null) {
            if (nextA.val < nextB.val) {
                current.next = nextA;
                nextA = nextA.next;
            } else {
                current.next = nextB;
                nextB = nextB.next;
            }
            current = current.next;
        }

        if (nextA == null) {
            current.next = nextB;
        } else {
            current.next = nextA;
        }
        return head;
    }
}