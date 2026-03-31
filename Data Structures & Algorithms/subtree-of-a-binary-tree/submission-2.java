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
       public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return root == subRoot;
        if (root.val == subRoot.val && isSame(root, subRoot))
            return true;
        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);
        return leftAns || rightAns;

    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        boolean leftAns = p.val == q.val && isSame(p.left, q.left);
        boolean rightAns = p.val == q.val && isSame(p.right, q.right);

        return leftAns && rightAns;
    }
}
