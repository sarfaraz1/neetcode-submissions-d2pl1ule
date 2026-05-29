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
    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        createMap(inorder);

        postOrderIndex = postorder.length - 1;
        return build(postorder, 0, postorder.length - 1);


    }


    TreeNode build(int[] postOrder, int left, int right) {

        if (left > right) return null;
        int rootValue = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = map.get(rootValue);

        root.right = build(postOrder, inOrderIndex + 1, right);
        root.left = build(postOrder, left, inOrderIndex - 1);


        return root;
    }

    private void createMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

    }
}