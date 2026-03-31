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


        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode nextHead;

        while (currHead!= null){
            nextHead = currHead.next;
            currHead.next = prevHead;
            prevHead = currHead;
            currHead = nextHead;
        }
        
        
        return prevHead;

    }
}
