class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination){
            return true;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        createAdjacencyList(adj, edges);
        visited[source] = true;
        bfs(adj, visited, source, destination);
        return visited[destination];
    }
    private void createAdjacencyList(List<List<Integer>> adj, int[][] edges){
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
    private void bfs(List<List<Integer>> adj, boolean[] visited, int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()){
            int node = q.remove();
            
            for (int n : adj.get(node)){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                    if(n == end){
                        return;
                    }
                }
            }
        }
    }
}