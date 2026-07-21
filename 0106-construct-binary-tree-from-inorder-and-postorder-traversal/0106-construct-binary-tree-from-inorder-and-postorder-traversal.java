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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        int r = postorder[postorder.length-1];

        int idx = 0;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i]==r){
                idx = i;
                break;
            }
        }

        TreeNode node = new TreeNode(r);

        // Number of nodes in left subtree
        int leftSize = idx;

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, idx), Arrays.copyOfRange(postorder, 0, leftSize));

        node.right = buildTree(Arrays.copyOfRange(inorder, idx+1, inorder.length), Arrays.copyOfRange(postorder, leftSize, postorder.length-1));


        return node;
    }
}