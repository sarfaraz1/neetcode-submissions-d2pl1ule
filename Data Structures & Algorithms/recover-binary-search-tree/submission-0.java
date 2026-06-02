/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev, first, middle, last;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            int val = first.val;
            first.val = last.val;
            last.val = val;
        } else if (first != null && middle != null) {
            int val = middle.val;
            middle.val = first.val;
            first.val = val;

        }

    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        // for adjacent use-case
        if (root.val < prev.val && first == null) {
            first = prev;
            middle = root;
        } else if (root.val < prev.val) {
            last = root;
        }

        prev = root;
        inorder(root.right);
    }
}