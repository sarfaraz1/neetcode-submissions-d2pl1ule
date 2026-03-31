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
  public ListNode removeNthFromEnd(ListNode head, int n) {
        // put in hashmap
        // find out the index
        // reach to that that node
        // delete that node
        // if index is zero return index 1 node otherwise return 0the index node


        Map<Integer, ListNode> indexToNode = new HashMap<>();
        ListNode temp = head;
        indexToNode.put(0, head);
        int i = 0;
        while (temp.next != null) {
            i++;
            temp = temp.next;
            indexToNode.put(i, temp);
        }

        int indexToDelete = indexToNode.size() - n;
        ListNode nodeToDelete = indexToNode.get(indexToDelete);

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr != null) {
            if (curr == nodeToDelete && indexToDelete != 0) {
                prev.next = next;
                curr = head;
                break;
            } else if (curr == nodeToDelete) {
                curr = head.next;
                break;
            } else {
                prev = curr;
                curr = next;
                next = next == null ? null : next.next;
            }
        }
        return indexToNode.size() == 1 ? null : curr;

    }
}