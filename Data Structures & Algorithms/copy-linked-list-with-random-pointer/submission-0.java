/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
 public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head, res;

        // add new node to the middle
        while (temp != null) {
            res = new Node(temp.val);
            res.next = temp.next;
            temp.next = res;
            temp = temp.next.next;
        }

        // add random pointer
        temp = head;
        res = head.next;
        while (temp != null) {
            res.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
            if (res.next != null)
                res = res.next.next;
        }

        // detach new list from the old list
        temp = head;
        Node newHead = head.next;
        res = newHead;

        while (temp != null) {
            temp.next = temp.next.next;

            if (res.next != null) {
                res.next = res.next.next;
            }

            temp = temp.next;
            res = res.next;
        }
        return newHead;
    }
}
