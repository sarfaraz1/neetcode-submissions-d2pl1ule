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
    Map<Integer, Integer> map = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        createMap(inorder);

        return build(preorder, 0, preorder.length - 1);
    }

    TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = map.get(rootValue);

        root.left = build(preorder, left, inOrderIndex - 1);
        root.right = build(preorder, inOrderIndex + 1, right);

        return root;
    }

    private void createMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }
}
