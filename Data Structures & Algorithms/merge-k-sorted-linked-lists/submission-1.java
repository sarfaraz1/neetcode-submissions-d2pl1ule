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
     public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a.val - b.val;
                }
        );

        for (ListNode list : lists) {
            pq.add(list);
        }

        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = node;
            node = node.next;
            if (node != null) pq.add(node);
        }

        return dNode.next;
    }
}
