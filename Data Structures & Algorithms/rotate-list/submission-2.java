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
     public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode tail = head, curr = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int rotations = k % length;

        if (rotations == 0)
            return head;
        
        int newTail = length - rotations;
        tail.next = head;

        while (newTail > 1) {
            curr = curr.next;
            newTail--;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}