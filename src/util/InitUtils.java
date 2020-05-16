package util;

import pojo.SinglyLinkedListNode;

public class InitUtils {

    public static SinglyLinkedListNode initSinglyLinkedList(int... values) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode next = null;
        for(int x : values) {
            SinglyLinkedListNode temp = new SinglyLinkedListNode(x);
            if(next == null) {
                next = temp;
                head = temp;
            } else {
                next.next = temp;
                next = temp;
            }
        }
        return head;
    }
}
