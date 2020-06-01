package problems;

import pojo.SinglyLinkedListNode;

/**
     Given a linked list, remove the nth node from the end of list and return its head.

     For example,
     Given linked list: 1->2->3->4->5, and n = 2.
     After removing the second node from the end, the linked list becomes 1->2->3->5.

     Note:

     If n is greater than the size of the list, remove the first node of the list.

     Try doing it using constant additional space.
 */
public class RemoveNthNodeFromEnd {

    public SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode A, int B) {
        if(A == null) {
            return null;
        }
        if(B == 0) {
            return A;
        }

        SinglyLinkedListNode start = A;
        for(int i = 1; i < B; i++) {
            if(start == null) {
                return A.next;
            }
            start = start.next;
        }

        if(start == null) {
            return A.next;
        }

        SinglyLinkedListNode current = A;
        SinglyLinkedListNode prev = null;
        while(start.next != null) {
            prev = current;
            current = current.next;
            start = start.next;
        }

        if(prev != null) {

            prev.next = current == null ? null : current.next;
        } else {
            return A.next;
        }

        return A;
    }
}