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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        if (head.next == null && head.val == val)
            return null;

        ListNode prev = null, curr = head, next = head.next;

        while (curr != null) {
            if (curr.val == val && curr == head) {
                curr = curr.next;
                head = curr;
                next = next == null ? null : next.next;
            } else if (curr.val == val) {
                prev.next = curr.next;
                curr = next;
                next = next == null ? null : next.next;
            } else {
                prev = curr;
                curr = next;
                next = next == null ? null : next.next;
            }
        }

        return head;
    }
}