class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        int[] courseSeq = new int[numCourses];

        //Kahn's Algorithm
        int i  = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            courseSeq[i++] = node;

            for(int neighbour : adj.get(node)){
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        if(i == numCourses){
            return courseSeq;
        }
        return new int[0];
    }
}