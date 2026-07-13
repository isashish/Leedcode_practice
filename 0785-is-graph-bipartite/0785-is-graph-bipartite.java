class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!bfs(graph, color, i)){
                    return false;
                }

            }

        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        // 1 -> red, 0 -> blue
        color[node] = 0;
        while(!queue.isEmpty()){
            int front = queue.remove();
            int c = color[front];
            for(int n : graph[front]){
                if(color[n] == color[front]){
                    return false;
                }
                if(color[n] == -1){
                    color[n] = 1 - c;
                    queue.add(n);
                }

            }
        }
        return true;
    }
}