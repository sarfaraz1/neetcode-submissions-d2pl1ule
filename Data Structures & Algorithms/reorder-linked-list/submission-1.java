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
 public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode secondList = middleNode.next;
        middleNode.next = null;
        ListNode secondListHead = reverseLinkedList(secondList);


        while (secondListHead != null) {
            ListNode tempSec = secondListHead.next;
            ListNode temp = head.next;
            head.next = secondListHead;
            secondListHead.next = temp;
            head = temp;
            secondListHead = tempSec;
        }

    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;


        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
