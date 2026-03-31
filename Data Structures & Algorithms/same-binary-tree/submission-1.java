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
       boolean ans = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        isSame(p, q);
        return ans;
    }

    public void isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return;
        if ((p == null && q != null) || (p != null && q == null)){
              ans = false;
              return;
        }
          

        ans = ans && p.val == q.val;
        if(ans == false) return;
        isSame(p.left, q.left);
        isSame(p.right, q.right);

    }
}
