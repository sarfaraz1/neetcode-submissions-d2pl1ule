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
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> hasVisited = new HashMap<>();
        hasVisited.put(head, true);
        while (head != null) {
            head = head.next;
            if (hasVisited.get(head) != null) {
                return true;
            }
            hasVisited.put(head, true);
        }

        return false;
    }
}
