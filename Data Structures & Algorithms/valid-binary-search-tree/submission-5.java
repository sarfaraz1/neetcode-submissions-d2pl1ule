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
     public boolean isValidBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean validateBST(TreeNode root, int minVal, Integer maxValue) {
        // a null tree is always a valid BST
        if (root == null) return true;

        if (root.val >= maxValue || root.val <= minVal)
            return false;


        // for left subtree max value is root's value
        return validateBST(root.left, minVal, root.val) &&
                // for right subtree min value is root's value
                validateBST(root.right, root.val, maxValue);

    }
}
