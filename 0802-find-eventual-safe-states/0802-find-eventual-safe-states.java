class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList());
        }

        int[] inDegree = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                int index = graph[i][j];
                adj.get(index).add(i);
            }
            inDegree[i] = graph[i].length;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for(int neighbor : adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}