class Solution {
    private class Edge{
        int node;
        double probability;
        public Edge(int node, double probability){
            this.node = node;
            this.probability = probability;
        }
    }
    private double dijkstrasAlgo(List<List<Edge>> adj, int start, int end){
        double[] prob = new double[adj.size()];

        for(int i = 0; i < prob.length; i++){
            prob[i] = 0.0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.probability, a.probability)
        );

        prob[start] = 1.0;
        pq.offer(new Edge(start, 1.0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.probability;

            // Optional optimization:
            // Skip outdated entry
            if (currProb < prob[currNode]) {
                continue;
            }

            for(Edge neighbor : adj.get(currNode)){
                double newProb = neighbor.probability * currProb;
                if(newProb > prob[neighbor.node]){
                    prob[neighbor.node] = newProb;
                    pq.offer(new Edge(neighbor.node, newProb));
                }
            }
        }

        if(prob[end] == 0.0){
            return 0;
        }
        return prob[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> adj = new ArrayList<>();
        int V = n;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Edge(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Edge(edge[0], succProb[i]));
            i++;
        }
        return dijkstrasAlgo(adj, start_node, end_node);
    }
}