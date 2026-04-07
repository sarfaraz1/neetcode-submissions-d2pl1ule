/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode currA = headA, currB = headB;

        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }

        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }
        int diff;
        currA = headA;
        currB = headB;
        if (lengthA > lengthB) {

            diff = lengthA - lengthB;

            while (diff != 0) {
                currA = currA.next;
                diff--;
            }


        } else if (lengthB > lengthA) {
            diff = lengthB - lengthA;
            while (diff != 0) {
                currB = currB.next;
                diff--;
            }

        }

        while (currA != null && currB != null) {

            if (currA == currB)
                return currA;


            currA = currA.next;
            currB = currB.next;


        }

        return null;
    }
}