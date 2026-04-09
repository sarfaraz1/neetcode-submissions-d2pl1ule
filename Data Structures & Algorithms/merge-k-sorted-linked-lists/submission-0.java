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
        if(lists.length==0) return null;
        
        int n = lists.length;
        ListNode initialList = lists[0];
        for (int i = 1; i < n; i++) {
            initialList = mergeLists(initialList, lists[i]);
        }

        return initialList;
    }

    ListNode mergeLists(ListNode first, ListNode second) {
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;

        while (first != null && second != null) {
            if (first.val < second.val) {
                temp.next = first;
                temp = first;
                first = first.next;
            } else {
                temp.next = second;
                temp = second;
                second = second.next;
            }

            if (first != null) temp.next = first;
            else temp.next = second;
        }

        return dNode.next;
    }
}
