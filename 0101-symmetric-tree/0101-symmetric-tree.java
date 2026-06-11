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
    private boolean isMirrorNode(TreeNode leftSide, TreeNode rightSide){
        if(leftSide == null && rightSide == null){
            return true;
        }

        if(leftSide == null || rightSide == null){
            return false;
        }

        if(leftSide.val != rightSide.val){
            return false;
        }

        return isMirrorNode(leftSide.left, rightSide.right) && isMirrorNode(leftSide.right, rightSide.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isMirrorNode(root.left, root.right);
    }
}