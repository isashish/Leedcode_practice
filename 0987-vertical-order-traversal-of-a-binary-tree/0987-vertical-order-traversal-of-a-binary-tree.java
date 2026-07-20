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
    private class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    private class NodeInfo {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0, 0));

        HashMap<Integer, List<NodeInfo>> map = new HashMap<>();

        int min = 0;
        int max = 0;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            min = Math.min(min, curr.col);
            max = Math.max(max, curr.col);

            map.computeIfAbsent(curr.col, k -> new ArrayList<>()).add(new NodeInfo(curr.row, curr.node.val));

            if(curr.node.left != null){
                queue.offer(new Pair(curr.node.left, curr.row + 1, curr.col - 1));
            }
            if(curr.node.right != null){
                queue.offer(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        for(int i = min; i <= max; i++){
            if (!map.containsKey(i)) 
                continue;
            
            List<NodeInfo> list = map.get(i);

            Collections.sort(list, (a, b) -> {
                if(a.row != b.row){
                    return a.row - b.row;
                }
                return a.val - b.val;
            });

            List<Integer> temp = new ArrayList<>();

            for(NodeInfo x : list) {
                temp.add(x.val);
            }
            ans.add(temp);
        }

        return ans;

    }
}