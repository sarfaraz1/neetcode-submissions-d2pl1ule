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
      List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return rsView(root, 0);
    }

    private List<Integer> rsView(TreeNode root, int level) {
        if (root == null) return null;
        if (result.size() == level)
            result.add(root.val);

        rsView(root.right, level + 1);
        rsView(root.left, level + 1);

        return result;
    }
}
