class Solution {
    private static class Edge{
        int node;
        int cost;
        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    private int dijkstrasAlgo(List<List<Edge>> adj, int start){
        int[] dis = new int[adj.size()];

        for(int i = 0; i < dis.length; i++){
            dis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        dis[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.node;
            int currCost = curr.cost;

            for(Edge neighbor : adj.get(currNode)){
                int newCost = neighbor.cost + currCost;
                if(newCost < dis[neighbor.node]){
                    dis[neighbor.node] = newCost;
                    pq.offer(new Edge(neighbor.node, newCost));
                }
            }
        }

        int max = 0;

        for (int distance : dis) {
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, distance);
        }

        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int V = n;
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int source = time[0];
            int destination = time[1];
            int cost = time[2];
            adj.get(source - 1).add(new Edge(destination - 1, cost));
        }
        
        return dijkstrasAlgo(adj, k-1);
    }
}