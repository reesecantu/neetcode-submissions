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
    public boolean isBalanced(TreeNode root) {
        // global variable
        int result = heightBalanced(root);
        return result != -1;
    }

    private int heightBalanced(TreeNode root) {
        if (root == null) return 0;
        int right = heightBalanced(root.right);
        int left = heightBalanced(root.left);
        if (right == -1 || left == -1) return -1;
        if (Math.abs(right - left) > 1) return -1;
        return Math.max(right, left) + 1;
    }
}
