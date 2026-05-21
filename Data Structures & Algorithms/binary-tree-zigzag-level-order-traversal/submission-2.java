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
        int flag = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                al.add(curr.val);

            }
            if (flag == 1)
                Collections.reverse(al);

            ans.add(al);
            flag = 1 - flag;


        }
        return ans;
    }
}