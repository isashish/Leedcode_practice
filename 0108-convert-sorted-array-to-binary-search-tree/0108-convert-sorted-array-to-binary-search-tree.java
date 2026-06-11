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
    private TreeNode insert(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;

        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = insert(nums, start, mid-1);
        newNode.right = insert(nums, mid+1, end);

        return newNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length-1);
    }
}