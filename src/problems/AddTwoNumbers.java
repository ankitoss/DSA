/** HashTags
 * #FB
 * #LeetCode
 * #LinkedList
 */

/** Problem Description
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in each linked list is in the range [1, 100].
 *     0 <= Node.val <= 9
 *     It is guaranteed that the list represents a number that does not have leading zeros.
 */
package problems;

import pojo.SinglyLinkedListNode;

public class AddTwoNumbers {

    public SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode next1 = l1;
        SinglyLinkedListNode next2 = l2;
        SinglyLinkedListNode result = null;
        SinglyLinkedListNode resNext = null;
        int carry = 0;
        while (next1 != null || next2 != null) {
            int sum;
            SinglyLinkedListNode ln;
            if (next1 == null) {
                sum = next2.val;
            } else if (next2 == null) {
                sum = next1.val;
            } else {
                sum = next1.val + next2.val;
            }
            sum += carry;
            if (sum > 9) {
                ln = new SinglyLinkedListNode(sum - 10);
                carry = 1;
            } else {
                ln = new SinglyLinkedListNode(sum);
                carry = 0;
            }
            if (result == null) {
                resNext = ln;
                result = ln;
            } else {
                resNext.next = ln;
            }
            resNext = ln;
            if (next1 != null) next1 = next1.next;
            if (next2 != null) next2 = next2.next;
        }
        if (carry != 0) {
            resNext.next = new SinglyLinkedListNode(carry);
        }
        return result;
    }
}
