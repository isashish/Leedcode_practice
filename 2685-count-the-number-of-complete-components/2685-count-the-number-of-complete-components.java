class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        createAdjacencyList(adj, edges);
        int count = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                count += bfs(i, adj, visited);
            }
        }
        return count;
    }
    private int bfs(int i, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = true;
        int nodes = 0;
        int edgeCount = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            nodes++;
            edgeCount += adj.get(node).size();  //sum of degrees
            for (int n : adj.get(node)){
                if(!vis[n]){
                    queue.add(n);
                    vis[n] = true;
                }
            }
        }
        int noOfEdges = edgeCount/2;
        return isComplete(nodes, noOfEdges) == true ? 1 : 0;
    }
    private boolean isComplete(int nodes, int noOfEdges){
        int expectedEdges = nodes*(nodes-1)/2;
        return expectedEdges == noOfEdges;
    }
    private void createAdjacencyList(List<List<Integer>> adj, int[][] edges){
        for (int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }
}