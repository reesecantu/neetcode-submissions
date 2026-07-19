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
    public int diameterOfBinaryTree(TreeNode root) {
        // for each node, largest path I can make is right depth + left,
        // max over every node.

        // don't do double work, bottom up

        return dobtHelper(root)[0];
    }

    /**
        @returns int[] maxPathLength, height.
    */
    public int[] dobtHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dobtHelper(root.left);
        int[] right = dobtHelper(root.right);

        int myLargestPath = left[1] + right[1];
        int maxOverallPath = Math.max(Math.max(myLargestPath, left[0]), right[0]);
        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{maxOverallPath, height};
    }
}
