package problems;

import pojo.SinglyLinkedListNode;

public class SinglyLinkedListPalindrome {

    public boolean isPalindrome(SinglyLinkedListNode root) {
        if (root == null || root.next == null) {
            return true;
        }

        if (root.next.next == null) {
            return root.val == root.next.val;
        }


        SinglyLinkedListNode slow = root;
        SinglyLinkedListNode fast = root;
        SinglyLinkedListNode slowPrev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        SinglyLinkedListNode sec;
        if (fast == null) {
            sec = slow;
            slowPrev.next = null;
        } else {
            sec = slow.next;
            slow.next = null;
        }

        SinglyLinkedListNode cur = sec;
        SinglyLinkedListNode prev = null;
        while (cur != null) {
            SinglyLinkedListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        boolean find = true;

        SinglyLinkedListNode left = root;
        SinglyLinkedListNode right = prev;
        // System.out.print("mid: " + sec.val + " l: " + left.val + " r: " + right.val + " ");
        while (find) {
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                } else {
                    left = left.next;
                    right = right.next;
                }
            } else {
                find = false;
            }
        }
        return true;
    }
}
