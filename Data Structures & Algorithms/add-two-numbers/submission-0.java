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
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, curr;
        ListNode dummyNode = new ListNode(-1);
        curr = dummyNode;
        int sum, carry = 0;

        while (t1 != null || t2 != null) {
            sum=0;
            sum += carry;
            if (t1 != null) sum += t1.val;
            if (t2 != null) sum += t2.val;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;


        }

        if (carry != 0)
            curr.next = new ListNode(carry);

        return dummyNode.next;
    }
}
