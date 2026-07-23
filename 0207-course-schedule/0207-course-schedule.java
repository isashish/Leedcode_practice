class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] vis = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] course : prerequisites){
            int directedNode = course[0];
            int node = course[1];
            adj.get(node).add(directedNode);
        }

        int[] inDegree = new int[numCourses];

        for(int i = 0; i < adj.size(); i++){
            for(int node : adj.get(i)){
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();

        //Kahn's Algorithm
        while (!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);

            for(int neighbour : adj.get(node)){
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        return topo.size() == numCourses;
    }
}