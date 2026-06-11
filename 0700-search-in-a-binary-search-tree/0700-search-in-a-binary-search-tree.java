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
    private TreeNode findSubTree(TreeNode node, int val){
        if(node == null){
            return null;
        }
        if(node.val == val){
            return node;
        }
        else if(node.val < val){
            //find in right side
            return findSubTree(node.right, val);
        }
        else if(node.val > val){
            //find in left side
            return findSubTree(node.left, val);
        }
        return null;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return findSubTree(root, val);
    }
}