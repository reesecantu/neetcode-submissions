/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode sentinal = new ListNode();
        while (head != null) {
            sentinal.next = new ListNode(head.val, sentinal.next);
            head = head.next;
        }

        return sentinal.next;
    }
}
