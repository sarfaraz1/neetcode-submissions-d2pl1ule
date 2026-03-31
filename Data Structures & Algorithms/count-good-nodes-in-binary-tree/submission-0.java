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
     int result = 0;

    public int goodNodes(TreeNode root) {

        getNumberOfGoodNodes(root.left, root.val);
        getNumberOfGoodNodes(root.right, root.val);

        return result + 1;
    }

    private void getNumberOfGoodNodes(TreeNode root, int maxValue) {
        if (root == null) return;
        if (root.val >= maxValue) {
            maxValue = root.val;
            result++;

        }
        getNumberOfGoodNodes(root.left, maxValue);
        getNumberOfGoodNodes(root.right, maxValue);

    }
}
