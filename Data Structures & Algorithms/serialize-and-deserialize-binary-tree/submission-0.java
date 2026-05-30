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

public class Codec {

   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null)
                sb.append("n ");

            else {
                sb.append(curr.val).append(" ");

                q.add(curr.left);
                q.add(curr.right);
            }


        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodes = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode curr = q.poll();
            if (!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                q.add(left);

            }

            if (!nodes[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                q.add(right);

            }

        }

        return root;

    }
}
