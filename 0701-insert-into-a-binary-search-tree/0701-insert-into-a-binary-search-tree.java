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
    private TreeNode insert(TreeNode node, int val){
        if(node == null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if(node.val < val){
            //insert into the right side
            node.right = insert(node.right, val);
        }
        if(node.val > val){
            //insert into the left side
            node.left = insert(node.left, val);
        }
        return node;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
}