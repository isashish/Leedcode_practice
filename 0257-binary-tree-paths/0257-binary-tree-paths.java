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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        StringBuilder str = new StringBuilder();
        findPath(root, str, list);
        return list;
    }
    private void findPath(TreeNode node, StringBuilder str, List<String> list){
       
        if(node == null){
            return;
        }
        int length = str.length();

        if(str.length() > 0){
            str.append("->");
        }

        str.append(node.val);

        //If leaf node
        if(node.left == null && node.right == null){
            list.add(str.toString());
        }
        else {
            //left subtree
            findPath(node.left, str, list);

            //right subtree
            findPath(node.right, str, list);
        }

        str.setLength(length);
    }
}