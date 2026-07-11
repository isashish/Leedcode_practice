class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }
    private static void bfs(int i, boolean[] vis, int[][] adj){
        vis[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()){
            int front = queue.remove();
            for (int j = i; j < adj[i].length; j++){
                if(adj[front][j] == 1 && vis[j] == false){
                    queue.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}