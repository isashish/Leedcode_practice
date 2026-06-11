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
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
}