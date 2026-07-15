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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<Integer> seen = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        int pVal = p.val;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            seen.add(current.val);
            if (current.val > pVal) {
                stack.push(current.left);
            } else if (current.val < pVal) {
                stack.push(current.right);
            } else {
                break;
            }
        }

        TreeNode smallest = new TreeNode();
        int qVal = q.val;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if(seen.contains(current.val)) {
                smallest = current;
            }
            
            if (current.val > qVal) {
                stack.push(current.left);
            } else if (current.val < qVal) {
                stack.push(current.right);
            } else {
                break;
            }
        }

        return smallest;
    }
}
