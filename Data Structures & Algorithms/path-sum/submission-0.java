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
      public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, 0, targetSum);


    }

    private boolean solve(TreeNode root, int sumTillNow, int targetSum) {
        if (root == null)
            return false;
        
        sumTillNow += root.val;
        if (root.left == null && root.right == null) {
            if (sumTillNow == targetSum) return true;
            return false;
        }


        return solve(root.left, sumTillNow, targetSum) || solve(root.right, sumTillNow, targetSum);


    }
}