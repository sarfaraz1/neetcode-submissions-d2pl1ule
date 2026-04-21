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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dNode = new ListNode();
        dNode.next = head;
        ListNode prev = dNode, curr = head;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
            curr = curr.next;
        }

        int windowSize = right - left + 1;

        prev.next = reverseLinkList(curr, windowSize);

        return dNode.next;
    }

    ListNode reverseLinkList(ListNode head, int windowSize) {
        ListNode prev = null, curr = head, next = head.next;

        while (windowSize > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next == null ? null : next.next;
            windowSize--;
        }

        head.next = curr;
        return prev;
    }
}