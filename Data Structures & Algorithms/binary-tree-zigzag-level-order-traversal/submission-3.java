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
       public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int qSize = q.size();
            LinkedList<Integer> al = new LinkedList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                if (leftToRight)
                    al.addLast(curr.val);
                else
                    al.addFirst(curr.val);

            }

            ans.add(al);
            leftToRight = !leftToRight;


        }
        return ans;
    }
}