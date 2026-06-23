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
    private List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    private Double calculateAverage(List<Integer> list){
        double sum = 0;
        for(int n : list){
            sum += n;
        }
        return sum/list.size();
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        levels = levelOrder(root);

        List<Double> result = new ArrayList<>();

        for(List<Integer> level : levels){
            double avgCurr = calculateAverage(level);
            result.add(avgCurr);
        }
        return result;
    }
}